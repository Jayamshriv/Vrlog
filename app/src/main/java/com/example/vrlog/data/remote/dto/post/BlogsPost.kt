package com.example.vrlog.data.remote.dto.post


import com.example.vrlog.domain.model.post.BlogsPostModel

data class BlogsPost (
    val postList :ArrayList<BlogsPostItem>
)

fun BlogsPost.toBlogsPostModel(): BlogsPostModel {
    return BlogsPostModel(
        postListModel = ArrayList(postList.map {
            it.toBlogsPostItemModel()
        })
    )
}