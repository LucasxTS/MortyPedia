package com.example.mortypedia.ui.features.character

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mortypedia.domain.models.CharactersModel
import com.example.mortypedia.domain.network.repositories.CharacterRepository
import com.example.mortypedia.domain.viewState.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CharacterViewModel(private val characterRepository: CharacterRepository) : ViewModel() {
    var nameSearchQuery by mutableStateOf("")
        private set

    var locationQuery by mutableStateOf("")
        private set

    var selectedStatus by mutableStateOf<Int?>(null)
        private set

    private val _uiState = MutableStateFlow<ViewState<List<CharactersModel>>>(ViewState.Loading)
    val uiState: StateFlow<ViewState<List<CharactersModel>>> = _uiState

    fun fetchData() {
        viewModelScope.launch {
            characterRepository.getAllData()
                .onStart { _uiState.value = ViewState.Loading }
                .catch { e -> _uiState.value = ViewState.Error(e.message ?: "Unknow Error") }
                .collect { result ->
                        if (result.isSuccess) {
                            _uiState.value = ViewState.Success(result.getOrNull()?.results ?: emptyList())
                        } else {
                            _uiState.value = ViewState.Error(result.exceptionOrNull()?.message ?: "Erro desconhecido")
                        }

                }
        }
    }
}