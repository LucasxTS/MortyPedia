package com.example.mortypedia.commons.di

import com.example.mortypedia.domain.network.ApiClient
import com.example.mortypedia.domain.network.repositories.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { provideUserViewModel(get()) }
}

fun provideUserViewModel(apiClient: ApiClient): CharacterRepository  {
   return CharacterRepository(apiClient)
}


