package com.pos.pucpr.webservicehomework.remote.dto.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DateDiffDTO(
    val dateFinish: String,
    val dateStart: String
)