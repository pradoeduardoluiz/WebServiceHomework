package com.pos.pucpr.webservicehomework

import android.app.Application
import com.pos.pucpr.webservicehomework.di.createDomainModule
import com.pos.pucpr.webservicehomework.di.createRemoteModule
import com.pos.pucpr.webservicehomework.di.createRepositoryModule
import com.pos.pucpr.webservicehomework.di.createUiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                createUiModule,
                createDomainModule,
                createRepositoryModule,
                createRemoteModule
            )
        }
    }

}