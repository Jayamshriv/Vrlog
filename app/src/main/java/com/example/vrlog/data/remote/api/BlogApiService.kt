package com.example.vrlog.data.remote.api

import com.example.vrlog.data.remote.dto.post.BlogsPostItem
import retrofit2.http.GET
import retrofit2.http.Query

interface BlogApiService {

    @GET("/wp-json/wp/v2/posts?")
    suspend fun getBlogsPost(
        @Query("per_page") perPage: Int,
        @Query("page") page: Int)
    : List<BlogsPostItem>

}

