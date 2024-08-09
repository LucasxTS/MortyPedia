package com.example.mortypedia.commons.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mortypedia.ui.features.character.CharacterScreen
import com.example.mortypedia.ui.features.locations.LocationsScreen
import org.koin.androidx.compose.get


@Composable
fun FlowView(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.CHARACTERS.name) {
        composable(Routes.CHARACTERS.name) {
           CharacterScreen(navController = navController, get())
        }
        composable(Routes.LOCATIONS.name) {
            LocationsScreen(navController = navController)
        }
    }
}