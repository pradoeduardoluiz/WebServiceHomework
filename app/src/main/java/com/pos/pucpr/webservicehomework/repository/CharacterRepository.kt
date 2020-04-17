package com.pos.pucpr.webservicehomework.repository

import com.pos.pucpr.webservicehomework.models.json.CharacterResponse

interface CharacterRepository {

    suspend fun getCharacters(page: Int): CharacterResponse

}