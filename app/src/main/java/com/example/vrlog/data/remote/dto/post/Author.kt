package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("embeddable")
    val embeddable: Boolean,
    @SerializedName("href")
    val href: String
)