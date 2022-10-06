package com.phil.enumclass.network

import com.squareup.moshi.Json

data class Photo(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @Json(name = "download_url") val imgSrcUrl: String
)

