package com.example.mortypedia.commons.navigation.bottomNavgation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mortypedia.commons.navigation.Routes

sealed class BottomNavItems(val route: Routes, val icon: ImageVector, val label: String) {
     object Characters: BottomNavItems(Routes.CHARACTERS, Icons.Default.Home, "Characters")
     object Locations: BottomNavItems(Routes.LOCATIONS, Icons.Default.LocationOn,"Locations")
     object Episodes: BottomNavItems(Routes.EPISODES, Icons.Default.PlayArrow, "Episodes")
}