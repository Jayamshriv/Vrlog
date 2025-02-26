package com.example.vrlog.presentation.viewmodel

import com.example.vrlog.domain.model.post.BlogsPostItemModel

data class BlogsPostState (
    val isLoading : Boolean = false,
    val post : List<BlogsPostItemModel> = emptyList(),
    val error : String = "",
)