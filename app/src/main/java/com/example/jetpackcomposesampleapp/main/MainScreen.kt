package com.example.jetpackcomposesampleapp.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesampleapp.cart.CartActivity
import com.example.jetpackcomposesampleapp.category.CategoriesActivity
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                   // .height(100.dp)
                    .clip(RoundedCornerShape(40.dp,40.dp,0.dp,0.dp)),
                    containerColor = AppMainColor,
            ) {
                BottomBar(navController = navController)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {

                    val intent = Intent(context, CartActivity::class.java)
                    context.startActivity(intent)



//                    Screen.Camera.route?.let {
//                        navController.navigate(it) {
//                            popUpTo(navController.graph.findStartDestination().id) {
//                                saveState = true
//                            }
//                            launchSingleTop = true
//                            restoreState = true
//                        }
//                    }
//                    Screen.Camera.route?.let { navController.navigate(it) }
//

                },
                containerColor = AppMainColor,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "Add Item")
            }
        }
    ) {
        BottomNavGraph(navController = navController)

    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Order,
        BottomBarScreen.Offer,
        BottomBarScreen.Setting,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier
            .padding(12.dp, 0.dp, 12.dp, 0.dp)
            .height(100.dp)
            .background((AppMainColor)),
        containerColor = Color.Transparent
        //containerColor = AppMainColor
        ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
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
                indicatorColor = AppMainColor.copy(0.5f),//MaterialTheme.colorScheme.surfaceColorAtElevation(LocalAbsoluteTonalElevation.current)
                unselectedIconColor = Color.White.copy(0.4f),
                unselectedTextColor = Color.White.copy(0.4f),
                selectedTextColor = Color.White
            ),
       // unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {

                //to reach start destination

                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },

    )
}
/*
@Composable
fun MyBottomBar(contextForToast: Context) {
    val bottomBarItemsList = mutableListOf<BottomBarItem>()
    bottomBarItemsList.add(BottomBarItem(icon = Icons.Default.Home, name = "Home"))
    bottomBarItemsList.add(BottomBarItem(icon = Icons.Default.Person, name = "Profile"))
    bottomBarItemsList.add(BottomBarItem(icon = Icons.Default.Favorite, name = "Favorites"))

    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar {
        bottomBarItemsList.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.name) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    Toast.makeText(contextForToast, item.name, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

data class BottomBarItem(val icon: ImageVector, val name: String)*/

