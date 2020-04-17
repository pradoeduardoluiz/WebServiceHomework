package com.pos.pucpr.webservicehomework.remote.mappers

import com.pos.pucpr.webservicehomework.models.json.CharacterResponse
import com.pos.pucpr.webservicehomework.remote.dto.json.CharacterResponseDTO

fun CharacterResponse.toDto() =
    CharacterResponseDTO(
        info.toDto(),
        characters.map { it.toDto() }

    )

fun CharacterResponseDTO.toModel() =
    CharacterResponse(
        info.toModel(),
        characters.map { it.toModel() }
    )