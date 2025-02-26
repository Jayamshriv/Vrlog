package com.example.vrlog.domain.usecase

import com.example.vrlog.domain.repository.BlogsApiRepository
import javax.inject.Inject

class BlogsPostUseCase @Inject constructor(
    private val repository: BlogsApiRepository
) {
    fun getBlogsPost(perPage: Int, page: Int) = repository.getBlogsPost(perPage, page)
}
