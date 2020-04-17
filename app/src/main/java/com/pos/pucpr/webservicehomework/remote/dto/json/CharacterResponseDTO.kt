package com.pos.pucpr.webservicehomework.remote.dto.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CharacterResponseDTO(
    val info: InfoDTO,
    @Json(name = "results")
    val characters: List<CharacterDTO>
)