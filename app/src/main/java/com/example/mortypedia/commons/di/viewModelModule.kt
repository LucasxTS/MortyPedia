package com.example.mortypedia.commons.di

import com.example.mortypedia.domain.network.repositories.CharacterRepository
import com.example.mortypedia.ui.features.character.CharacterViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { CharacterViewModel(get()) }
}

