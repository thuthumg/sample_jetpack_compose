package com.example.jetpackcomposesampleapp.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title:String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Dashboard
    )

    object Order: BottomBarScreen(
        route = "order",
        title = "Order",
        icon = Icons.Default.Storefront
    )

    object Offer: BottomBarScreen(
        route = "offer",
        title = "Offer",
        icon = Icons.Default.CardGiftcard
    )

    object Setting: BottomBarScreen(
        route = "setting",
        title = "Setting",
        icon = Icons.Default.Settings
    )

}
