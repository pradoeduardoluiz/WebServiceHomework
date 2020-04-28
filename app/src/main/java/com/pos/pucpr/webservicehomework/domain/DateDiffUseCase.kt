package com.pos.pucpr.webservicehomework.domain

import com.pos.pucpr.webservicehomework.common.Either
import com.pos.pucpr.webservicehomework.common.Failure
import com.pos.pucpr.webservicehomework.common.Success
import com.pos.pucpr.webservicehomework.common.ext.DateUtils
import com.pos.pucpr.webservicehomework.models.json.DateDiff
import com.pos.pucpr.webservicehomework.models.json.DateDiffResponse
import com.pos.pucpr.webservicehomework.repository.Exercise2Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class DateDiffUseCase(private val repository: Exercise2Repository) {

    suspend fun invoke(dateStart: String, dateFinish: String): Either<Exception, DateDiffResponse> {
        val brazilianFormat =
            SimpleDateFormat(DateUtils.DEFAULT_DATE_BRAZILIAN, Locale.getDefault())
        val defaultFormat = SimpleDateFormat(DateUtils.DEFAULT_DATE_PATTERN, Locale.getDefault())
        return try {
            withContext(Dispatchers.IO) {
                val dateDiff = DateDiff(
                    dateFinish = defaultFormat.format(brazilianFormat.parse(dateFinish) ?: ""),
                    dateStart = defaultFormat.format(brazilianFormat.parse(dateStart) ?: "")
                )
                val response = repository.diffBetweenDates(dateDiff)
                Success(response)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Failure(e)
        }
    }

}