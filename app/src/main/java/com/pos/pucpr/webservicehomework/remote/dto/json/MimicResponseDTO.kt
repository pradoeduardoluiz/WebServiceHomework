package com.pos.pucpr.webservicehomework.remote.dto.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MimicResponseDTO(
        val text: String
)