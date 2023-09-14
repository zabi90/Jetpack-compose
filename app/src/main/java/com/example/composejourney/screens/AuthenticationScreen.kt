package com.example.composejourney.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composejourney.composables.MenuSwitch
import com.example.composejourney.composables.MenuSwitchItem
import com.example.composejourney.ui.theme.Dark_100
import com.example.composejourney.ui.theme.Dark_80

@Composable
fun AuthenticationScreen(navController: NavController) {
    var menuIndex by remember { mutableStateOf(0) }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.headlineLarge,
            color = Dark_100,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )
        Text(
            text = "Sign up or login to your Account.",
            style = MaterialTheme.typography.bodyLarge,
            color = Dark_80,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        MenuSwitch(
            listOf(
                MenuSwitchItem(0, "Login", true),
                MenuSwitchItem(1, "Sign Up", false)
            ), {
                menuIndex = it.index
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp)
        )

        when(menuIndex){
            0 -> {
                LoginScreen(
                    navController,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
            1 -> {
                SignUpScreen(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun authenticationScreenPreview() {
    val navController = rememberNavController()
    AuthenticationScreen(navController)
}