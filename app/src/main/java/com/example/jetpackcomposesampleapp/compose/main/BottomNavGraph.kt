package com.example.jetpackcomposesampleapp.compose.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposesampleapp.compose.cart.CartScreen
import com.example.jetpackcomposesampleapp.compose.home.HomeScreen
import com.example.jetpackcomposesampleapp.compose.offer.OfferScreen
import com.example.jetpackcomposesampleapp.compose.order.OrderScreen
import com.example.jetpackcomposesampleapp.compose.setting.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }

        composable(route = BottomBarScreen.Order.route){
            OrderScreen()
        }

        composable(route = BottomBarScreen.Offer.route){
            OfferScreen()
        }

        composable(route = BottomBarScreen.Setting.route){
            SettingsScreen()
        }

        composable(route = BottomBarScreen.Cart.route){
            CartScreen()
        }

    }
    
}