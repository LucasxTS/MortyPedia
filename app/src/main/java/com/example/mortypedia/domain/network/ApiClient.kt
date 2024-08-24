package com.example.mortypedia.domain.network

import com.example.mortypedia.domain.models.CharacterResponseApi
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Response<CharacterResponseApi>
}













