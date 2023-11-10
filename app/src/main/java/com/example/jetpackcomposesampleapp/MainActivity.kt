package com.example.jetpackcomposesampleapp

import android.app.Activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposesampleapp.compose.category.CategoryScreen
import com.example.jetpackcomposesampleapp.compose.category.ProductItemListScreen
import com.example.jetpackcomposesampleapp.compose.detail.DetailScreen
import com.example.jetpackcomposesampleapp.compose.main.MainScreen
import com.example.jetpackcomposesampleapp.compose.offer.discountdetail.DiscountDetail
import com.example.jetpackcomposesampleapp.compose.setting.CreateCategoryScreen
import com.example.jetpackcomposesampleapp.ui.theme.GroceryAppTheme

class MainActivity : ComponentActivity() {


    private val viewModel: MainViewModel by viewModels()

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryAppTheme {
                GroceryApp(viewModel)
            }
        }
    }

    @Composable
    private fun GroceryApp(viewModel: MainViewModel) {
        val navController = rememberNavController()
        // MainScreen(navController = navController)
        GroceryNavHost(navController = navController,viewModel)

    }

    @Composable
    fun GroceryNavHost(navController: NavHostController, viewModel: MainViewModel) {
        val activity = (LocalContext.current as Activity)
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                MainScreen(
                   // navController = navController,
                    onCategoryItemClick = {
                        Log.d("main act","check category id ${it.categoryId}")
                        navController.navigate("categoryDetail/${it.categoryId}/${it.categoryName}/productList")
                    },
                    onSeeAllClick = {
                        navController.navigate("categoryList")
                    },
                    onDiscountItemClick = {
                        navController.navigate("discountDetail/${it.discountId}/discountList")
                    },
                    onCreateCategoryClick = {
                        navController.navigate("createCategory")
                    },
                    viewModel
                )
            }
            composable(
                "createCategory",

                ) {
                CreateCategoryScreen(
                )
            }
            composable(
                "categoryList",

                ) {
                CategoryScreen(
                    onBackClick = { navController.navigateUp() },
                    onCategoryItemClick = {

                     //   val bundle = Bundle()
                     //   bundle.putString("amount", it.categoryName)

                        navController.navigate("categoryDetail/${it.categoryId}/${it.categoryName}/productList")
                    }
                )
            }
            composable(
                "categoryDetail/{categoryId}/{categoryName}/productList",
                arguments = listOf(navArgument("categoryId") {
                    type = NavType.StringType
                }, navArgument("categoryName"){
                    type = NavType.StringType
                })
            ) {it->
                val categoryName =
                    it.arguments?.get("categoryName") as String

                val categoryIdParam =
                    it.arguments?.get("categoryId") as String

                ProductItemListScreen(

                    onBackClick = { navController.navigateUp() },
                    onGroceryItemClick = { productItemVO, categoryId ->
                        navController.navigate(
                            "categoryDetail/${categoryId}/productList/${productItemVO.itemId}/productDetail"
                        )
                    },
                    categoryName,
                    categoryIdParam
                )
            }
            composable(
                "categoryDetail/{categoryId}/productList/{groceryProductItemId}/productDetail",
                arguments = listOf(navArgument("categoryId") {
                    type = NavType.StringType
                },
                    navArgument("groceryProductItemId") {
                        type = NavType.StringType
                    })

            ) {
                DetailScreen(
                    pageState = false,
                    onBackClick = { navController.navigateUp() })
            }
            composable(
                "discountDetail/{discountItemCategoryId}/productList/{discountItemId}/productDetail",
                arguments = listOf(navArgument("discountItemCategoryId") {
                    type = NavType.StringType
                },
                    navArgument("discountItemId") {
                        type = NavType.StringType
                    })

            ) {
                DetailScreen(
                    pageState = true,
                    onBackClick = { navController.navigateUp() })
            }
            composable(
                "discountDetail/{itemId}/discountList",
                arguments = listOf(navArgument("itemId") {
                    type = NavType.StringType
                })
                ) {

                DiscountDetail(
                    onDiscountItemProductClick = {
                        navController.navigate("discountDetail/${it.itemCategoryType}/productList/${it.itemId}/productDetail")
                    }
                )
            }
            /* composable(
                "gallery/{plantName}",
                arguments = listOf(navArgument("plantName") {
                    type = NavType.StringType
                })
            ) {
                GalleryScreen(
                    onPhotoClick = {
                        val uri = Uri.parse(it.user.attributionUrl)
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        activity.startActivity(intent)
                    },
                    onUpClick = {
                        navController.navigateUp()
                    })
            }*/


        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   // val navController = rememberNavController()
    GroceryAppTheme {
      //  MainScreen(navController = navController)
    }
}