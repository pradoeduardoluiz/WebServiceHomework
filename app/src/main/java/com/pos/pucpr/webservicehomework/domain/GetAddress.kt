package com.pos.pucpr.webservicehomework.domain

import com.pos.pucpr.webservicehomework.common.Either
import com.pos.pucpr.webservicehomework.common.Failure
import com.pos.pucpr.webservicehomework.common.Success
import com.pos.pucpr.webservicehomework.models.xml.CepResponse
import com.pos.pucpr.webservicehomework.repository.CepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAddress(private val repository: CepRepository) {

    suspend fun invoke(cep: String): Either<Exception, CepResponse> {
        return try {
            withContext(Dispatchers.IO) {
                val response = repository.getAddress(cep)
                Success(response)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Failure(e)
        }
    }

}