package com.pos.pucpr.webservicehomework.di

import com.pos.pucpr.webservicehomework.domain.GetCharacters
import com.pos.pucpr.webservicehomework.presentation.JsonListViewModel
import com.pos.pucpr.webservicehomework.remote.CharacterService
import com.pos.pucpr.webservicehomework.remote.NetworkConstants
import com.pos.pucpr.webservicehomework.remote.NetworkFactory
import com.pos.pucpr.webservicehomework.remote.repositories.CharacterRepositoryImpl
import com.pos.pucpr.webservicehomework.repository.CharacterRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val createUiModule: Module = module {
    viewModel { JsonListViewModel(get()) }
}

val createDomainModule: Module = module {
    single { GetCharacters(get()) }
}

val createRepositoryModule: Module = module {
    factory<CharacterRepository> { CharacterRepositoryImpl(get()) }
}

val createRemoteModule: Module = module {
    single { NetworkFactory.createRetrofit(NetworkConstants.JSON_BASE_URL, get()) }
    single { get<Retrofit>().create(CharacterService::class.java) }
}