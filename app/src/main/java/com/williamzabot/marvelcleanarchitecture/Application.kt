package com.williamzabot.marvelcleanarchitecture

import android.app.Application
import com.williamzabot.data.di.dataModule
import com.williamzabot.data.remote.di.networkModule
import com.williamzabot.domain.di.domainModule
import com.williamzabot.marvelcleanarchitecture.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@Application)
            modules(
                presentationModule,
                dataModule,
                networkModule,
                domainModule
            )
        }
    }

}