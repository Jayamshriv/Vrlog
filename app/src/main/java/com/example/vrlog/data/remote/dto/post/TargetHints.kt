package com.example.vrlog.data.remote.dto.post


import com.google.gson.annotations.SerializedName

data class TargetHints(
    @SerializedName("allow")
    val allow: List<String>
)