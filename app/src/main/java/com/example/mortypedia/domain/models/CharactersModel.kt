package com.example.mortypedia.domain.models

data class CharactersModel(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class CharacterResponseApi(
    val results: List<CharactersModel>
)