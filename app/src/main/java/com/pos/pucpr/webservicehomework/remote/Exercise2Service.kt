package com.pos.pucpr.webservicehomework.remote

import com.pos.pucpr.webservicehomework.remote.dto.json.*
import retrofit2.http.Body
import retrofit2.http.POST

interface Exercise2Service {

    @POST("date")
    suspend fun diffBetweenDates(@Body dateDiffDTO: DateDiffDTO): ResponseDTO<DateDiffResponseDTO>

    @POST("numberSequence")
    suspend fun numberSequence(@Body numberSequenceDTO: NumberSequenceDTO): ResponseDTO<NumberSequenceResponseDTO>

    @POST("mimic")
    suspend fun mimic(@Body mimicDTO: MimicDTO): ResponseDTO<MimicResponseDTO>

}