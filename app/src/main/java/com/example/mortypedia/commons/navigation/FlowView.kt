package com.example.mortypedia.commons.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mortypedia.domain.models.Routes
import com.example.mortypedia.ui.features.character.CharacterScreen
import com.example.mortypedia.ui.features.locations.LocationsScreen

@Composable
fun FlowView(
    navController: NavHostController,
    context: Context
) {
    NavHost(navController = navController, startDestination = Routes.CHARACTERS.name) {
        composable(Routes.CHARACTERS.name) {
           CharacterScreen(navController = navController)
        }
        composable(Routes.LOCATIONS.name) {
            LocationsScreen(navController = navController)
        }
    }
}