package com.example.mortypedia.commons.di

import com.example.mortypedia.domain.usecase.charactersFilters.LocationFilter
import com.example.mortypedia.domain.usecase.charactersFilters.NameFilter
import com.example.mortypedia.domain.usecase.charactersFilters.StatusFilter
import org.koin.dsl.module

val useCaseModule =  module {

    factory { NameFilter() }
    factory { LocationFilter() }
    factory { StatusFilter() }
}