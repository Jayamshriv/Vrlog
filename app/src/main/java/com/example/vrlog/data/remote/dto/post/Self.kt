package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class Self(
    @SerializedName("href")
    val href: String,
    @SerializedName("targetHints")
    val targetHints: TargetHints
)