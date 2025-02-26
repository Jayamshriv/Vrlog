package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("protected")
    val `protected`: Boolean,
    @SerializedName("rendered")
    val rendered: String
)