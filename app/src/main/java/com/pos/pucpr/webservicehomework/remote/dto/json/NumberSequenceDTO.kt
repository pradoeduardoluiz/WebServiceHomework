package com.pos.pucpr.webservicehomework.remote.dto.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberSequenceDTO(
    val numbersSequence: String
)