package com.pos.pucpr.webservicehomework.remote.mappers

import com.pos.pucpr.webservicehomework.models.json.Origin
import com.pos.pucpr.webservicehomework.remote.dto.json.OriginDTO


fun Origin.toDto() =
    OriginDTO(name, url)

fun OriginDTO.toModel() =
    Origin(name, url)
