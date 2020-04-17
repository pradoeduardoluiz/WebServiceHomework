package com.pos.pucpr.webservicehomework.remote.mappers

import com.pos.pucpr.webservicehomework.models.xml.CepResponse
import com.pos.pucpr.webservicehomework.remote.dto.xml.CepResponseDTO


fun CepResponse.toDto() =
    CepResponseDTO(district, cep, complement, gia, ibge, locale, street, uf, unity)

fun CepResponseDTO.toModel() =
    CepResponse(
        district ?: "",
        cep ?: "",
        complement ?: "",
        gia ?: "",
        ibge ?: "",
        locale ?: "",
        street ?: "",
        uf ?: "",
        unity ?: ""
    )
