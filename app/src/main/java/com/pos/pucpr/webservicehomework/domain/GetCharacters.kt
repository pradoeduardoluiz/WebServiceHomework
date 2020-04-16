package com.pos.pucpr.webservicehomework.domain

import com.pos.pucpr.webservicehomework.common.Either
import com.pos.pucpr.webservicehomework.common.Failure
import com.pos.pucpr.webservicehomework.common.Success
import com.pos.pucpr.webservicehomework.models.CharacterResponse
import com.pos.pucpr.webservicehomework.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCharacters(private val repository: CharacterRepository) {

    suspend fun invoke(page: Int): Either<Exception, CharacterResponse> {
        return try {
            withContext(Dispatchers.IO) {
                val response = repository.getCharacters(page)
                Success(response)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Failure(e)
        }
    }

}