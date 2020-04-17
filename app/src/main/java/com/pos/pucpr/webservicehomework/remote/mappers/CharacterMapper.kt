package com.pos.pucpr.webservicehomework.remote.mappers

import com.pos.pucpr.webservicehomework.models.json.Character
import com.pos.pucpr.webservicehomework.remote.dto.json.CharacterDTO

fun Character.toDto() =
    CharacterDTO(
        created,
        episode,
        gender,
        id,
        image,
        location.toDto(),
        name,
        origin.toDto(),
        species,
        status,
        type,
        url
    )

fun CharacterDTO.toModel() =
    Character(
        created,
        episode,
        gender,
        id,
        image,
        location.toModel(),
        name,
        origin.toModel(),
        species,
        status,
        type,
        url
    )