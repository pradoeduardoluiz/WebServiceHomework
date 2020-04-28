package com.pos.pucpr.webservicehomework.models.json

data class DateDiffResponse(
    val differenceInDays: Int,
    val differenceInMonths: Int,
    val differenceInWeeks: Int
)