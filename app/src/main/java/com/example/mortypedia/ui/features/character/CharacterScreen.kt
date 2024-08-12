package com.example.mortypedia.ui.features.character

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mortypedia.domain.viewState.ViewState
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = koinViewModel()
) {
    val viewState by viewModel.uiState.collectAsState()

    when (viewState) {
        is ViewState.Loading -> {

        }
        is ViewState.Success -> {

        }
        is ViewState.Error -> {

        }
    }

    LaunchedEffect(Unit) {

        viewModel.fetchData()
    }
}

@Preview
@Composable
fun CharacterScreenPreview() {
    CharacterScreen(navController = rememberNavController())
}