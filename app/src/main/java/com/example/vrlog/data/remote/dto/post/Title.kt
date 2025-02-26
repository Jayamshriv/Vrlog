package com.example.vrlog.data.remote.dto.post


import com.example.vrlog.domain.model.post.TitleModel
import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("rendered")
    val rendered: String
)

fun Title.toTitleModel(): TitleModel {
    return TitleModel(rendered)
}