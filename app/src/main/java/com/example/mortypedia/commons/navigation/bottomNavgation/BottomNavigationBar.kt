package com.example.mortypedia.commons.navigation.bottomNavgation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mortypedia.R
import com.example.mortypedia.commons.navigation.Routes

@Composable
fun BottomNavigationBar(currentRoute: Routes, onRouteSelected: (Routes) -> Unit) {

    val items = listOf(
        BottomNavItems.Characters,
        BottomNavItems.Locations,
        BottomNavItems.Episodes,
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.background_color_image),
        elevation = 44.dp,
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))

    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = {
                    Text(
                        item.label,
                        color = Color.White
                    )
                        },
                selected = currentRoute == item.route,
                onClick = { onRouteSelected(item.route) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(currentRoute = Routes.CHARACTERS, onRouteSelected = {})
}