package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class PredecessorVersion(
    @SerializedName("href")
    val href: String,
    @SerializedName("id")
    val id: Int
)