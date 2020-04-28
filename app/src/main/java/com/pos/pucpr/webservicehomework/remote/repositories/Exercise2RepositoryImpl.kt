package com.pos.pucpr.webservicehomework.remote.repositories

import com.pos.pucpr.webservicehomework.models.json.*
import com.pos.pucpr.webservicehomework.remote.Exercise2Service
import com.pos.pucpr.webservicehomework.remote.mappers.toDto
import com.pos.pucpr.webservicehomework.remote.mappers.toModel
import com.pos.pucpr.webservicehomework.repository.Exercise2Repository

class Exercise2RepositoryImpl(val api: Exercise2Service) : Exercise2Repository {

    override suspend fun diffBetweenDates(dateDiff: DateDiff): DateDiffResponse {
        return api.diffBetweenDates(dateDiff.toDto()).data.toModel()
    }

    override suspend fun numberSequence(numberSequence: NumberSequence): NumberSequenceResponse {
        return api.numberSequence(numberSequence.toDto()).data.toModel()
    }

    override suspend fun mimic(mimic: Mimic): MimicResponse {
        return api.mimic(mimic.toDto()).data.toModel()
    }
}