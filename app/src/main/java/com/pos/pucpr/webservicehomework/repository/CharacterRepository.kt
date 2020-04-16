package com.pos.pucpr.webservicehomework.repository

import com.pos.pucpr.webservicehomework.models.CharacterResponse

interface CharacterRepository {

    suspend fun getCharacters(page: Int): CharacterResponse

}