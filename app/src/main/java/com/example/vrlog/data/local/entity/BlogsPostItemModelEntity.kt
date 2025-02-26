package com.example.vrlog.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.vrlog.core.utils.Constants
import com.example.vrlog.domain.model.post.BlogsPostItemModel
import com.example.vrlog.domain.model.post.TitleModel

@Entity(tableName = Constants.TABLE_NAME)
data class BlogsPostItemModelEntity(
    @PrimaryKey(autoGenerate = true)
    val uid : Int=0,

    val date: String,
    val id: Int,
    val jetpackFeaturedMediaUrl: String,
    val link: String,
    val title: String
)

fun BlogsPostItemModelEntity.toBlogsPostItemModel() : BlogsPostItemModel {
    return BlogsPostItemModel(date,id,jetpackFeaturedMediaUrl,link,TitleModel(title))
}