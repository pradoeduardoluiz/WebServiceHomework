package com.pos.pucpr.webservicehomework.remote

import android.content.Context
import com.pos.pucpr.webservicehomework.remote.utils.isInternetAccessible
import com.pos.pucpr.webservicehomework.remote.utils.isNetworkAvailable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.io.IOException

object NetworkFactory {

    private val LOGGING_LEVEL: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY

    fun createLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = LOGGING_LEVEL
    }

    private fun createOkHttpClient(context: Context) = OkHttpClient.Builder()
        .addInterceptor(createLoggingInterceptor())
        .addInterceptor(createConnectivityAwareInterceptor(context))
        .build()

    fun createRetrofit(
        url: String,
        context: Context,
        factory: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(createOkHttpClient(context))
        .addConverterFactory(factory)
        .build()

    private fun createConnectivityAwareInterceptor(context: Context): Interceptor {
        return Interceptor { chain ->
            if (!context.isNetworkAvailable() && !isInternetAccessible()) throw IOException()
            else chain.proceed(chain.request())
        }
    }

}