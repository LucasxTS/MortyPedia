package com.example.mortypedia.commons.di


import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val apiModule = module {

}

fun provideUserApi() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}