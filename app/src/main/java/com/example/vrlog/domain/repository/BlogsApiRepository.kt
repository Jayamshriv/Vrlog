package com.example.vrlog.domain.repository

import com.example.vrlog.core.utils.Resource
import com.example.vrlog.data.local.entity.BlogsPostItemModelEntity
import com.example.vrlog.domain.model.post.BlogsPostItemModel
import kotlinx.coroutines.flow.Flow

interface BlogsApiRepository {
    fun getBlogsPost(perPage: Int, page: Int): Flow<Resource<List<BlogsPostItemModel>>>

    suspend fun getBlogsPostFromLocal(): List<BlogsPostItemModelEntity>

    suspend fun insertBlogsPostInLocal(list: List<BlogsPostItemModelEntity>)

    suspend fun deleteLocal()
}
