package com.pos.pucpr.webservicehomework.domain

import com.pos.pucpr.webservicehomework.common.Either
import com.pos.pucpr.webservicehomework.common.Failure
import com.pos.pucpr.webservicehomework.common.Success
import com.pos.pucpr.webservicehomework.models.json.Mimic
import com.pos.pucpr.webservicehomework.models.json.MimicResponse
import com.pos.pucpr.webservicehomework.repository.Exercise2Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MimicUseCase(private val repository: Exercise2Repository) {

    suspend fun invoke(text: String): Either<Exception, MimicResponse> {
        return try {
            withContext(Dispatchers.IO) {
                val mimic = Mimic(
                    text = text
                )
                val response = repository.mimic(mimic)
                Success(response)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Failure(e)
        }
    }

}