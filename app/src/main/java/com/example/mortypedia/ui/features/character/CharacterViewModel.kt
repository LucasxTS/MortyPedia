package com.example.mortypedia.ui.features.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mortypedia.domain.models.CharacterResponseApi
import com.example.mortypedia.domain.network.ApiClient
import com.example.mortypedia.domain.network.repositories.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel(private val characterRepository: CharacterRepository) : ViewModel() {
    private val _characters = MutableLiveData<CharacterResponseApi>()

    fun getAllData() {
        viewModelScope.launch {
            try {
               val request = characterRepository.getAllData()
                if (request.isSuccessful) {
                    _characters.postValue(request.body())
                }
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}