package com.pos.pucpr.webservicehomework.remote.repositories

import com.pos.pucpr.webservicehomework.models.xml.CepResponse
import com.pos.pucpr.webservicehomework.remote.ViaCepService
import com.pos.pucpr.webservicehomework.remote.mappers.toModel
import com.pos.pucpr.webservicehomework.repository.CepRepository

class CepRepositoryImpl(private val api: ViaCepService) : CepRepository {

    override suspend fun getAddress(cep: String): CepResponse {
        return api.getAddress(cep).toModel()
    }
}