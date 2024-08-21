package com.example.mortypedia.domain.usecase.charactersFilters

import com.example.mortypedia.domain.models.CharactersModel


class StatusFilter {
    fun execute(characters: List<CharactersModel>, status: Int?): List<CharactersModel> {
        return when (status) {
            0 -> characters.filter { it.status.equals("Dead", ignoreCase = true) }
            1 -> characters.filter { it.status.equals("Alive", ignoreCase = true) }
            2 -> characters.filter { it.status.equals("Unknown", ignoreCase = true) }
            else -> characters
        }
    }
}