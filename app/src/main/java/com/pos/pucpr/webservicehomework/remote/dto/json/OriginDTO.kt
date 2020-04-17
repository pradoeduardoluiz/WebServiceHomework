package com.pos.pucpr.webservicehomework.remote.dto.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class OriginDTO(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)