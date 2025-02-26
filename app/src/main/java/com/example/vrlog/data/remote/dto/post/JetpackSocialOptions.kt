package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class JetpackSocialOptions(
    @SerializedName("image_generator_settings")
    val imageGeneratorSettings: ImageGeneratorSettings,
    @SerializedName("version")
    val version: Int
)