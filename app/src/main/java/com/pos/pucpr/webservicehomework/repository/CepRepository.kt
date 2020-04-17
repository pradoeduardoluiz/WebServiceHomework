package com.pos.pucpr.webservicehomework.repository

import com.pos.pucpr.webservicehomework.models.xml.CepResponse

interface CepRepository {

    suspend fun getAddress(cep: String): CepResponse

}