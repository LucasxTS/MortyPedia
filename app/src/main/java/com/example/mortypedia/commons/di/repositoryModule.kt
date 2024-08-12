package com.example.mortypedia.commons.di

import com.example.mortypedia.domain.network.ApiClient
import com.example.mortypedia.domain.network.repositories.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { CharacterRepository(get()) }
}




