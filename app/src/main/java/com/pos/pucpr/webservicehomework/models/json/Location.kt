package com.pos.pucpr.webservicehomework.models.json

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val name: String,
    val url: String
) : Parcelable