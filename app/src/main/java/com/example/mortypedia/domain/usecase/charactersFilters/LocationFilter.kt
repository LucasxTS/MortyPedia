package com.example.mortypedia.domain.usecase.charactersFilters

import com.example.mortypedia.domain.models.CharactersModel

class LocationFilter {
    fun execute(characters: List<CharactersModel>, location: String): List<CharactersModel> {
        return characters.filter { it.location.name.contains(location, ignoreCase = true) }
    }
}