package com.example.mortypedia.domain.network

import com.example.mortypedia.domain.models.CharacterResponseApi
import retrofit2.http.GET

interface ApiClient {

    @GET("/character")
    suspend fun getCharacters() : CharacterResponseApi

}