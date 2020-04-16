package com.pos.pucpr.webservicehomework.remote

import com.pos.pucpr.webservicehomework.remote.dto.CharacterResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponseDTO

}