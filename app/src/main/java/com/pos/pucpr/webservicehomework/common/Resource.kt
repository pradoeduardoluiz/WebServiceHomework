package com.pos.pucpr.webservicehomework.common

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    object Error : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
}