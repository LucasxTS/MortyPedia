    package com.example.mortypedia.ui.features.character

    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateListOf
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.setValue
    import androidx.compose.runtime.snapshots.SnapshotStateList
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
    import kotlinx.coroutines.flow.asStateFlow
    import kotlinx.coroutines.flow.catch
    import kotlinx.coroutines.flow.onStart
    import kotlinx.coroutines.launch

    class CharacterViewModel(
        private val characterRepository: CharacterRepository,
        private val nameFilter: NameFilter,
        private val locationFilter: LocationFilter,
        private val statusFilter: StatusFilter
    ) : ViewModel() {

        private var currentPage = 1

        var nameSearchQuery by mutableStateOf("")

        var locationQuery by mutableStateOf("")

        var selectedStatus by mutableStateOf<Int?>(1)

        private var originalCharacters = mutableListOf<CharactersModel>()

        private val _uiState = MutableStateFlow(mutableStateListOf<CharactersModel>())
        val uiState = _uiState.asStateFlow()

        var _isLoading = MutableStateFlow(false)
        var isLoading: StateFlow<Boolean> = _isLoading
        fun fetchData() {
            viewModelScope.launch {
                _isLoading.value = true
                characterRepository.getAllData(currentPage)
                    .collect { result ->
                            result.onSuccess {data ->
                                val newCharacters = data.results
                                originalCharacters.addAll(newCharacters)
                                _uiState.emit(originalCharacters.toSnapshot())
                                _isLoading.value = false
                                currentPage++
                            }
                        result.onFailure {
                            println(it)
                        }
                    }
            }
        }
        fun applyFilters() {
            val filteredByName = nameFilter.execute(originalCharacters, nameSearchQuery)
            val filterByLocation = locationFilter.execute(filteredByName, locationQuery)
            val filterByStatus = statusFilter.execute(filterByLocation, selectedStatus)
            viewModelScope.launch {
                _uiState.emit(filterByStatus.toSnapshot())
            }
        }

        private fun List<CharactersModel>.toSnapshot(): SnapshotStateList<CharactersModel> =
            SnapshotStateList<CharactersModel>().apply { addAll(this@toSnapshot)}
    }