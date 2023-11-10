package com.example.jetpackcomposesampleapp.compose.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposesampleapp.MainViewModel
import com.example.jetpackcomposesampleapp.compose.cart.CartScreen
import com.example.jetpackcomposesampleapp.compose.home.HomeScreen
import com.example.jetpackcomposesampleapp.compose.offer.OfferScreen
import com.example.jetpackcomposesampleapp.compose.order.OrderScreen
import com.example.jetpackcomposesampleapp.compose.setting.SettingsScreen
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.data.vos.DiscountCardItemVO

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    onCategoryItemClick: (CategoryItemVO) -> Unit,
    onSeeAllClick: () -> Unit,
    onDiscountItemClick: (DiscountCardItemVO) -> Unit,
    onCreateCategoryClick: () -> Unit,
    viewModel: MainViewModel
) {
    
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(
                onCategoryItemClick = onCategoryItemClick,
                onSeeAllClick = onSeeAllClick,
                viewModel
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
            SettingsScreen(
                onCreateCategoryClick = onCreateCategoryClick,
            )
        }

        composable(route = BottomBarScreen.Cart.route){
            CartScreen()
        }

    }
    
}