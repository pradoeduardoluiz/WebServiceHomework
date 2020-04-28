package com.pos.pucpr.webservicehomework.remote.dto.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DateDiffResponseDTO(
    val differenceInDays: Int,
    val differenceInMonths: Int,
    val differenceInWeeks: Int
)