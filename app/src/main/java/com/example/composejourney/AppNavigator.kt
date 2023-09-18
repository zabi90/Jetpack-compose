package com.example.composejourney

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composejourney.screens.AuthenticationScreen
import com.example.composejourney.screens.MainScreen
import com.example.composejourney.screens.OnBoardingScreen

object AppNavigator{

    @Composable
    fun App(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.ON_BOARDING){
            composable(Routes.ON_BOARDING){
                OnBoardingScreen(navController = navController)
            }
            composable(Routes.AUTHENTICATION){
                AuthenticationScreen(navController = navController)
            }
            composable(Routes.MAIN){
                MainScreen(navController = navController)
            }
        }
    }

    //Routes
    object Routes {
        const val AUTHENTICATION = "authentication"
        const val ON_BOARDING = "onBoarding"
        const val MAIN = "main"
    }
}