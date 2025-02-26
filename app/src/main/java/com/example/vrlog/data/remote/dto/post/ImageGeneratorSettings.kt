package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class ImageGeneratorSettings(
    @SerializedName("enabled")
    val enabled: Boolean,
    @SerializedName("template")
    val template: String
)