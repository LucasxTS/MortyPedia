package com.example.mortypedia.domain.network.repositories

import com.example.mortypedia.domain.models.CharacterResponseApi
import com.example.mortypedia.domain.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CharacterRepository(private val apiClient: ApiClient) {
      fun getAllData(page: Int): Flow<Result<CharacterResponseApi>> = flow {
        try {
            val response  = apiClient.getCharacters(page = page)
            if(response.isSuccessful) {
                val data = response.body()
                if(data != null) {
                    emit(Result.success(data))
                } else {
                    emit(Result.failure(Exception("No response")))
                }
            } else {
                emit(Result.failure(Exception("Request error: ${response.code()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)
}