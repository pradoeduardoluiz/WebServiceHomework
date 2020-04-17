package com.pos.pucpr.webservicehomework.remote.mappers

import com.pos.pucpr.webservicehomework.models.json.Location
import com.pos.pucpr.webservicehomework.remote.dto.json.LocationDTO

fun Location.toDto() =
    LocationDTO(
        name,
        url
    )

fun LocationDTO.toModel() =
    Location(
        name ?: "",
        url
    )
