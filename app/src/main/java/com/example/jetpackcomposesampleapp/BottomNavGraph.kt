package com.example.jetpackcomposesampleapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposesampleapp.screens.HomeScreen
import com.example.jetpackcomposesampleapp.screens.ProfileScreen
import com.example.jetpackcomposesampleapp.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }

        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }

        composable(route = BottomBarScreen.Setting.route){
            SettingsScreen()
        }
    }
    
}