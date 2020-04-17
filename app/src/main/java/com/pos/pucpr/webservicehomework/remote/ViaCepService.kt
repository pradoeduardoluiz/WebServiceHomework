package com.pos.pucpr.webservicehomework.remote

import com.pos.pucpr.webservicehomework.remote.dto.xml.CepResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {

    @GET("{cep}/xml/")
    suspend fun getAddress(@Path("cep") cep: String): CepResponseDTO

}