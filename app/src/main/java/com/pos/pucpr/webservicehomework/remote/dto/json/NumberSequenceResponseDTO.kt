package com.pos.pucpr.webservicehomework.remote.dto.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberSequenceResponseDTO(
    val ascendingOrder: String,
    val descendingOrder: String,
    val pairNumbers: String
)