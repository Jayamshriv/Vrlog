package com.example.vrlog.data.repository

import com.example.vrlog.core.utils.NetworkHelper
import com.example.vrlog.core.utils.Resource
import com.example.vrlog.data.local.dao.BlogsPostDao
import com.example.vrlog.data.local.entity.BlogsPostItemModelEntity
import com.example.vrlog.data.local.entity.toBlogsPostItemModel
import com.example.vrlog.data.remote.api.BlogApiService
import com.example.vrlog.data.remote.dto.post.toBlogsPostItemModel
import com.example.vrlog.domain.model.post.BlogsPostItemModel
import com.example.vrlog.domain.model.post.toBlogsPostItemModelEntity
import com.example.vrlog.domain.repository.BlogsApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BlogsApiRepositoryImpl @Inject constructor(
    private val apiService: BlogApiService,
    private val dao: BlogsPostDao,
    private val networkHelper: NetworkHelper
) : BlogsApiRepository {

    override fun getBlogsPost(perPage: Int, page: Int): Flow<Resource<List<BlogsPostItemModel>>> = flow {
        emit(Resource.Loading())

        try {
            if (networkHelper.isNetworkAvailable()) {
                val response = apiService.getBlogsPost(perPage, page)
                val blogPosts = response.map { it.toBlogsPostItemModel() }

                dao.deleteAll()

                dao.insertBlogs(blogPosts.map {
                    it.toBlogsPostItemModelEntity()
                }

                )

                emit(Resource.Success(blogPosts))
            } else {
                val localData = dao.getAllPosts().map { it.toBlogsPostItemModel() }
                if (localData.isEmpty()) {

                    emit(Resource.Error("No data available offline"))
                } else {

                    emit(Resource.Success(localData))

                }
            }
        } catch (e: Exception) {
            emit(Resource.Error("An error occurred: ${e.message}"))
        }
    }

    override suspend fun getBlogsPostFromLocal(): List<BlogsPostItemModelEntity> {
        return dao.getAllPosts()
    }

    override suspend fun insertBlogsPostInLocal(list: List<BlogsPostItemModelEntity>) {
        dao.insertBlogs(list)
    }

    override suspend fun deleteLocal() {

        dao.deleteAll()
    }
}
