package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class Excerpt(
    @SerializedName("protected")
    val `protected`: Boolean,
    @SerializedName("rendered")
    val rendered: String
)