package com.example.mortypedia

import android.app.Application
import com.example.mortypedia.commons.di.apiModule
import com.example.mortypedia.commons.di.repositoryModule
import com.example.mortypedia.commons.di.useCaseModule
import com.example.mortypedia.commons.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication() : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(
                apiModule,
                repositoryModule,
                viewModelModule,
                useCaseModule
            )
        }
    }
}