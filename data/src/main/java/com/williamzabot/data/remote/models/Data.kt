package com.williamzabot.data.remote.models

import com.google.gson.annotations.SerializedName

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @SerializedName("results") val heroes: List<Result>,
    val total: Int
)