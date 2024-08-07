package com.example.mortypedia

import android.app.Application
import com.example.mortypedia.commons.di.apiModule
import org.koin.core.context.startKoin

class AppApplication() : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                apiModule
            )
        }
    }
}