package com.example.jetpackcomposesampleapp.compose.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource

import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onCategoryItemClick : (CategoryItemVO)->Unit,
    onSeeAllClick : ()-> Unit
) {
    val childNavController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.White,
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier
                        // .height(100.dp)
                        .clip(RoundedCornerShape(
                            dimensionResource(R.dimen.dimen_card_corner_radius),
                            dimensionResource(R.dimen.dimen_card_corner_radius),
                            0.dp,
                            0.dp)),
                    containerColor = AppMainColor,
                ) {
                    BottomBar(navController = childNavController)
                }
            },

            )

        { innerPadding ->

            Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding()))
            {
                BottomNavGraph(
                    navController = childNavController,
                    onCategoryItemClick = onCategoryItemClick,
                    onSeeAllClick = onSeeAllClick)
            }


        }
    }


}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Order,
        BottomBarScreen.Cart,
        BottomBarScreen.Offer,
        BottomBarScreen.Setting,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier
            .padding(
                start = dimensionResource(R.dimen.margin_card_medium_2),
                top = 0.dp,
                end = dimensionResource(R.dimen.margin_card_medium_2),
                bottom = 0.dp
            )
            .height(100.dp)
            .background((AppMainColor)),
        containerColor = Color.Transparent
        //containerColor = AppMainColor
        ) {
        screens.forEach { screen ->
            NavigateEachItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.NavigateEachItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )

        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults
            .colors(
                selectedIconColor = Color.White,
                indicatorColor = AppMainColor.copy(0.5f),
                unselectedIconColor = Color.White.copy(0.4f),
                unselectedTextColor = Color.White.copy(0.4f),
                selectedTextColor = Color.White
            ),
        onClick = {
            navController.navigate(screen.route) {

                //to reach start destination

                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },

    )
}


