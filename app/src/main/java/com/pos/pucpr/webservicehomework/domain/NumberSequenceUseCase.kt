package com.pos.pucpr.webservicehomework.domain

import com.pos.pucpr.webservicehomework.common.Either
import com.pos.pucpr.webservicehomework.common.Failure
import com.pos.pucpr.webservicehomework.common.Success
import com.pos.pucpr.webservicehomework.models.json.NumberSequence
import com.pos.pucpr.webservicehomework.models.json.NumberSequenceResponse
import com.pos.pucpr.webservicehomework.repository.Exercise2Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NumberSequenceUseCase(private val repository: Exercise2Repository) {

    suspend fun invoke(sequence: String): Either<Exception, NumberSequenceResponse> {
        return try {
            withContext(Dispatchers.IO) {
                val numberSequence = NumberSequence(
                    numbersSequence = sequence
                )
                val response = repository.numberSequence(numberSequence)
                Success(response)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Failure(e)
        }
    }

}