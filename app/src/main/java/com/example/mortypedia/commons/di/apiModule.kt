package com.example.mortypedia.commons.di


import com.example.mortypedia.domain.network.ApiClient
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val apiModule = module {

     single { provideUserApi() }
}
fun provideUserApi(): ApiClient {
        val gson = GsonBuilder().create()
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiClient::class.java)
}

