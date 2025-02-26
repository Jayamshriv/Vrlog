package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class Guid(
    @SerializedName("rendered")
    val rendered: String
)