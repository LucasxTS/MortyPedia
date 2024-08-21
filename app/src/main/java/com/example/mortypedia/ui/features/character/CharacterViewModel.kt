package com.example.mortypedia.ui.features.character

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mortypedia.domain.models.CharactersModel
import com.example.mortypedia.domain.network.repositories.CharacterRepository
import com.example.mortypedia.domain.usecase.charactersFilters.LocationFilter
import com.example.mortypedia.domain.usecase.charactersFilters.NameFilter
import com.example.mortypedia.domain.usecase.charactersFilters.StatusFilter
import com.example.mortypedia.domain.viewState.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val characterRepository: CharacterRepository,
    private val nameFilter: NameFilter,
    private val locationFilter: LocationFilter,
    private val statusFilter: StatusFilter
) : ViewModel() {

    var nameSearchQuery by mutableStateOf("")

    var locationQuery by mutableStateOf("")

    var selectedStatus by mutableStateOf<Int?>(1)

    private var originalCharacters: List<CharactersModel> = listOf()

    private val _uiState = MutableStateFlow<ViewState<List<CharactersModel>>>(ViewState.Loading)
    val uiState: StateFlow<ViewState<List<CharactersModel>>> = _uiState

    fun fetchData() {
        viewModelScope.launch {
            characterRepository.getAllData()
                .onStart { _uiState.value = ViewState.Loading }
                .catch { e -> _uiState.value = ViewState.Error(e.message ?: "Unknow Error") }
                .collect { result ->
                        if (result.isSuccess) {
                            originalCharacters = (result.getOrNull()?.results ?: "") as List<CharactersModel>
                            _uiState.value = ViewState.Success(result.getOrNull()?.results ?: emptyList())
                        } else {
                            _uiState.value = ViewState.Error(result.exceptionOrNull()?.message ?: "Erro desconhecido")
                        }
                }
        }
    }
    fun applyFilters() {
        val filteredByName = nameFilter.execute(originalCharacters, nameSearchQuery)
        val filterByLocation = locationFilter.execute(filteredByName, locationQuery)
        val filterByStatus = statusFilter.execute(filterByLocation, selectedStatus)

        _uiState.value = ViewState.Success(filterByStatus)
    }
}