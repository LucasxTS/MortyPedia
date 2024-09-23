package com.example.mortypedia.ui.features.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mortypedia.domain.models.CharactersModel
import com.example.mortypedia.domain.viewState.ViewState
import com.example.mortypedia.ui.components.characterComponents.CharacterListComponent
import com.example.mortypedia.ui.components.characterComponents.HeaderComponent
import com.example.mortypedia.ui.components.characterComponents.IndeterminateLoading
import com.example.mortypedia.ui.components.characterComponents.LocationSearchBarComponent
import com.example.mortypedia.ui.components.characterComponents.NameSearchBarComponent
import com.example.mortypedia.ui.components.characterComponents.ToggleStatusComponent
import org.koin.androidx.compose.koinViewModel


@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = koinViewModel()
) {
    val isLoading = viewModel.isLoading.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }
    Column(
        Modifier.fillMaxSize()
    ) {
        HeaderComponent()
        NameSearchBarComponent(
            viewModel.nameSearchQuery
        ) {
            viewModel.nameSearchQuery = it
            viewModel.applyFilters()
        }
        LocationSearchBarComponent(
            viewModel.locationQuery
        ) {
            viewModel.locationQuery = it
            viewModel.applyFilters()
        }
        ToggleStatusComponent(viewModel)
        CharacterListComponent(viewModel)
    }
}

@Preview
@Composable
fun CharacterScreenPreview() {
    CharacterScreen(navController = rememberNavController())
}