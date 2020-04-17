package com.pos.pucpr.webservicehomework.remote.repositories

import com.pos.pucpr.webservicehomework.models.json.CharacterResponse
import com.pos.pucpr.webservicehomework.remote.CharacterService
import com.pos.pucpr.webservicehomework.remote.mappers.toModel
import com.pos.pucpr.webservicehomework.repository.CharacterRepository

class CharacterRepositoryImpl(private val api: CharacterService) : CharacterRepository {

    override suspend fun getCharacters(page: Int): CharacterResponse {
        return api.getCharacters(page).toModel()
    }

}