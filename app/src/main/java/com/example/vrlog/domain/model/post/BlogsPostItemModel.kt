package com.example.vrlog.domain.model.post

import com.example.vrlog.data.local.entity.BlogsPostItemModelEntity
import com.google.gson.annotations.SerializedName

data class BlogsPostItemModel(

    @SerializedName("date")
    val date: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("jetpack_featured_media_url")
    val jetpackFeaturedMediaUrl: String,

    @SerializedName("link")
    val link: String,

    @SerializedName("title")
    val title: TitleModel,
)

fun BlogsPostItemModel.toBlogsPostItemModelEntity() : BlogsPostItemModelEntity {
    return BlogsPostItemModelEntity(id=id, date = date, jetpackFeaturedMediaUrl = jetpackFeaturedMediaUrl, link = link, title = title.rendered)
}