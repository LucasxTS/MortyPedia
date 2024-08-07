package com.example.mortypedia.ui.features.character

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CharacterScreen(navController: NavController) {
    Text(text = "Hello World!")
}

@Preview
@Composable
fun CharacterScreenPreview() {
    CharacterScreen(navController = rememberNavController())
}