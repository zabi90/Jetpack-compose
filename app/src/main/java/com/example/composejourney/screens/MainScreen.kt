package com.example.composejourney.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composejourney.R
import com.example.composejourney.ui.theme.ComposeJourneyTheme
import com.example.composejourney.ui.theme.Light_80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            AppBottomNavigation(selectedItem, onItemSelected = {
                selectedItem = it
            })
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            when (selectedItem) {
                0 -> HomeScreen(navController = navController)
                else -> LoginScreen(navController = navController)
            }

            //Text(text = "Selected Item " + selectedItem)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    ComposeJourneyTheme {
        MainScreen(navController)
    }
}

@Composable
private fun AppBottomNavigation(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {


    NavigationBar(
        modifier = modifier,
        containerColor = Light_80,
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Home"
                )
            },
            selected = selectedItem == 0,
            onClick = {
                onItemSelected.invoke(0)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                indicatorColor = Light_80
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.discover),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Discover"
                )
            },
            selected = selectedItem == 1,
            onClick = { onItemSelected.invoke(1) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                indicatorColor = Light_80
            )

        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.car),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Drivethru"
                )
            },
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                indicatorColor = Light_80
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.receipt),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Orders"
                )
            },
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                indicatorColor = Light_80
            )
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            },
            label = {
                Text(
                    text = "Profile"
                )
            },
            selected = false,
            onClick = {},
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray,
                indicatorColor = Light_80
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppBottomNavigationPreview() {
    ComposeJourneyTheme {
        AppBottomNavigation(0, {})
    }
}

