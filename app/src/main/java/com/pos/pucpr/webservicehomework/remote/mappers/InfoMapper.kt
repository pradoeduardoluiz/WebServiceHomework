package com.pos.pucpr.webservicehomework.remote.mappers

import com.pos.pucpr.webservicehomework.models.json.Info
import com.pos.pucpr.webservicehomework.remote.dto.json.InfoDTO


fun Info.toDto() = InfoDTO(
    count,
    next,
    pages,
    prev
)

fun InfoDTO.toModel() =
    Info(count, next, pages, prev)
