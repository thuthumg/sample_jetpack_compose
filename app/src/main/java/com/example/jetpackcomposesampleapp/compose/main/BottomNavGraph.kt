package com.example.jetpackcomposesampleapp.compose.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposesampleapp.compose.cart.CartScreen
import com.example.jetpackcomposesampleapp.compose.home.HomeScreen
import com.example.jetpackcomposesampleapp.compose.offer.OfferScreen
import com.example.jetpackcomposesampleapp.compose.offer.discountdetail.DiscountDetail
import com.example.jetpackcomposesampleapp.compose.order.OrderScreen
import com.example.jetpackcomposesampleapp.compose.setting.SettingsScreen
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.data.vos.DiscountCardItemVO

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    onCategoryItemClick : (CategoryItemVO)->Unit,
    onSeeAllClick : ()-> Unit,
    onDiscountItemClick: (DiscountCardItemVO) -> Unit) {
    
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(
                onCategoryItemClick = onCategoryItemClick,
                onSeeAllClick = onSeeAllClick
            )
        }

        composable(route = BottomBarScreen.Order.route){
            OrderScreen()
        }

        composable(route = BottomBarScreen.Offer.route){
            OfferScreen(
                onDiscountItemClick = onDiscountItemClick
            )
        }

        composable(route = BottomBarScreen.Setting.route){
            SettingsScreen()
        }

        composable(route = BottomBarScreen.Cart.route){
            CartScreen()
        }

    }
    
}