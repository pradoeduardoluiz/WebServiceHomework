package com.pos.pucpr.webservicehomework.remote.mappers

import com.pos.pucpr.webservicehomework.models.json.*
import com.pos.pucpr.webservicehomework.remote.dto.json.*


fun DateDiff.toDto() =
    DateDiffDTO(dateFinish, dateStart)

fun DateDiffDTO.toModel() =
    DateDiff(dateFinish, dateStart)

fun DateDiffResponse.toDto() =
    DateDiffResponseDTO(differenceInDays, differenceInMonths, differenceInWeeks)

fun DateDiffResponseDTO.toModel() =
    DateDiffResponse(differenceInDays, differenceInMonths, differenceInWeeks)

fun NumberSequence.toDto() =
    NumberSequenceDTO(numbersSequence)

fun NumberSequenceDTO.toModel() =
    NumberSequence(numbersSequence)

fun NumberSequenceResponse.toDto() =
    NumberSequenceResponseDTO(ascendingOrder, descendingOrder, pairNumbers)

fun NumberSequenceResponseDTO.toModel() =
    NumberSequenceResponse(ascendingOrder, descendingOrder, pairNumbers)

fun Mimic.toDto() = MimicDTO(text)

fun MimicDTO.toModel() = Mimic(text)

fun MimicResponse.toDto() = MimicResponseDTO(text)

fun MimicResponseDTO.toModel() = MimicResponse(text)
