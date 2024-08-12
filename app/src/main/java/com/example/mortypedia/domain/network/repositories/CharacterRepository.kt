package com.example.mortypedia.domain.network.repositories

import com.example.mortypedia.domain.models.CharacterResponseApi
import com.example.mortypedia.domain.network.ApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.Koin
import retrofit2.Response

class CharacterRepository(private val apiClient: ApiClient) {
     suspend fun getAllData(): Flow<Response<CharacterResponseApi>> = flow {

    }
}