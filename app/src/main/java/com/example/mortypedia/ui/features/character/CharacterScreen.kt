package com.example.mortypedia.ui.features.character

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.get
import org.koin.androidx.compose.koinViewModel


@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getAllData()

    }
}

@Preview
@Composable
fun CharacterScreenPreview() {
    CharacterScreen(navController = rememberNavController())
}