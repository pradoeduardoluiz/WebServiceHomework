package com.pos.pucpr.webservicehomework.remote.dto.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InfoDTO(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "pages")
    val pages: Int,
    @Json(name = "prev")
    val prev: String
)