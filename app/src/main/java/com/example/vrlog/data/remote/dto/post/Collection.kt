package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("href")
    val href: String
)