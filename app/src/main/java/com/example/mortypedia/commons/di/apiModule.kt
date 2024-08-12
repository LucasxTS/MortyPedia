package com.example.mortypedia.commons.di


import com.example.mortypedia.domain.network.ApiClient
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val apiModule = module {

     single { GsonBuilder().create() }

     single { Retrofit.Builder()
         .baseUrl("https://rickandmortyapi.com/api/")
         .addConverterFactory(GsonConverterFactory.create(get()))
         .build()
         .create(ApiClient::class.java)
     }
}
