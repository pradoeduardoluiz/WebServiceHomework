package com.pos.pucpr.webservicehomework.repository

import com.pos.pucpr.webservicehomework.models.json.*

interface Exercise2Repository {

    suspend fun diffBetweenDates(dateDiff: DateDiff): DateDiffResponse

    suspend fun numberSequence(numberSequence: NumberSequence): NumberSequenceResponse

    suspend fun mimic(mimicDTO: Mimic): MimicResponse

}