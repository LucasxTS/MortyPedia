package com.example.mortypedia.domain.models


data class CharacterResponseApi(
    val results: List<CharactersModel>
)
data class CharactersModel(
    val id: Int,
    val status: String,
    val species: String,
    val gender: String,
    val location: LocationName,
    val image: String
)

data class LocationName (
    val name: String
)

