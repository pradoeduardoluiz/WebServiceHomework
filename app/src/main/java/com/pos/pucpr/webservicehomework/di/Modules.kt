package com.pos.pucpr.webservicehomework.di

import android.content.Context
import com.pos.pucpr.webservicehomework.domain.GetAddress
import com.pos.pucpr.webservicehomework.domain.GetCharacters
import com.pos.pucpr.webservicehomework.presentation.JsonListViewModel
import com.pos.pucpr.webservicehomework.presentation.XmlFormViewModel
import com.pos.pucpr.webservicehomework.remote.CharacterService
import com.pos.pucpr.webservicehomework.remote.NetworkConstants
import com.pos.pucpr.webservicehomework.remote.NetworkFactory
import com.pos.pucpr.webservicehomework.remote.ViaCepService
import com.pos.pucpr.webservicehomework.remote.repositories.CepRepositoryImpl
import com.pos.pucpr.webservicehomework.remote.repositories.CharacterRepositoryImpl
import com.pos.pucpr.webservicehomework.repository.CepRepository
import com.pos.pucpr.webservicehomework.repository.CharacterRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

val createUiModule: Module = module {
    viewModel { JsonListViewModel(get()) }
    viewModel { XmlFormViewModel(get()) }
}

val createDomainModule: Module = module {
    single { GetCharacters(get()) }
    single { GetAddress(get()) }
}

val createRepositoryModule: Module = module {
    factory<CharacterRepository> { CharacterRepositoryImpl(get()) }
    factory<CepRepository> { CepRepositoryImpl(get()) }
}

val createRemoteModule: Module = module {
    single {
        createRetrofit(
            NetworkConstants.JSON_BASE_URL,
            get(),
            MoshiConverterFactory.create()
        ).create(CharacterService::class.java)
    }
    single {
        createRetrofit(
            NetworkConstants.XML_BASE_URL,
            get(),
            SimpleXmlConverterFactory.create()
        ).create(ViaCepService::class.java)
    }
}


private fun createRetrofit(
    baseUrl: String,
    context: Context,
    factory: Converter.Factory
): Retrofit {
    return NetworkFactory.createRetrofit(baseUrl, context, factory)
}