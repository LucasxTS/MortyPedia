package com.example.mortypedia.domain.usecase.charactersFilters

import com.example.mortypedia.domain.models.CharactersModel

class NameFilter {
    fun execute(characters: List<CharactersModel>, name: String): List<CharactersModel> {
        return characters.filter { it.name.contains(name, ignoreCase = true) }
    }
}