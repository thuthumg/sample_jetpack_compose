package com.example.jetpackcomposesampleapp.compose.category

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesampleapp.compose.setting.CreateCategoryScreen
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.GroceryAppTheme

class CategoriesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppMainColor,

                ) {
                  //  val navController = rememberNavController()

                    CreateCategoryScreen()

                 /*   CategoriesScreen(
                        onBackClick = {
                            Log.d("categories","on click back")
                          //  navController.navigateUp()
                            onBackPressedDispatcher.onBackPressed()
                        }
                    )*/
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroceryAppTheme {
       // CategoriesScreen()
    }
}

