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
import com.example.mortypedia.ui.components.characterComponents.LocationSearchBarComponent
import com.example.mortypedia.ui.components.characterComponents.NameSearchBarComponent
import com.example.mortypedia.ui.components.characterComponents.ToggleStatusComponent
import org.koin.androidx.compose.koinViewModel


@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = koinViewModel()
) {
    val viewState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }
    Column(
        Modifier.fillMaxSize()
    ) {
        HeaderComponent()
        NameSearchBarComponent(viewModel)
        LocationSearchBarComponent(viewModel)
        ToggleStatusComponent(1, {})

        when (viewState) {
            is ViewState.Loading -> {

            }
            is ViewState.Success -> {
                val characters = (viewState as ViewState.Success<List<CharactersModel>>).data
                CharacterListComponent(charactersList = characters)
            }
            is ViewState.Error -> {
                println("Error on ViewState")
            }
        }
    }

}

@Preview
@Composable
fun CharacterScreenPreview() {
    CharacterScreen(navController = rememberNavController())
}