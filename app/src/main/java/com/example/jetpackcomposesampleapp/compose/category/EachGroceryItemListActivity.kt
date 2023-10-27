package com.example.jetpackcomposesampleapp.compose.category

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.compose.detail.SimilarProductEachItem
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
//import com.example.jetpackcomposesampleapp.data.vos.ProductItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.GroceryAppTheme
import com.example.jetpackcomposesampleapp.util.productList

class EachGroceryItemListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppMainColor
                ) {
                   // EachGroceryItemListScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EachGroceryItemListScreen(onBackClick : ()->Unit,onGroceryItemClick:(EachGroceryItemVO,Int)->Unit) {
    val mContext = LocalContext.current
    var showCustomBackDialog by remember { mutableStateOf(false) }

    var backDispatcher = LocalOnBackPressedDispatcherOwner.current

  /*  BackHandler(true, onBack = {

    },showCustomBackDialog,backDispatcher)*/

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor
    ) {
        Scaffold(
            containerColor = AppMainColor,
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = AppMainColor,
                        titleContentColor = Color.White
                    ),
                    title = {
                        Text(
                            text = "Fruits",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon =
                    {
                        IconButton(onClick = {
                            onBackClick()
                            // showCustomBackDialog = true
                        }) {
                            Icon(imageVector = Icons.Filled.ArrowBackIos, tint = Color.White, contentDescription = "Back")
                        }
                    }


                )
            }
        ){ innerPadding->

            /*  if(showCustomBackDialog)

              {
                  AlertDialog(
                      onDismissRequest = {
                      showCustomBackDialog = false
                  },
                      title = { Text("Custom Back Press Dialog") },
                      text = { Text("Do you really want to go back?") },
                      confirmButton = {
                          TextButton(
                              onClick = {
                                  showCustomBackDialog = false
                          }) {
                              Text("Yes")
                          }
                      },
                      dismissButton = {
                          TextButton(
                              onClick = {
                                  showCustomBackDialog = false
                              }) {
                              Text("No")
                          }
                      }

                  )
              }*/

            GroceryItemListLayout(innerPadding,onGroceryItemClick)


        }
    }

}

@Composable
private fun GroceryItemListLayout(
    innerPadding: PaddingValues,
    onGroceryItemClick: (EachGroceryItemVO, Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),

        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            topEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        ),
        ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.margin_medium),
                top = dimensionResource(id = R.dimen.margin_medium_2),
                end = dimensionResource(id = R.dimen.margin_medium),
                bottom = 0.dp),
            content = {
                items(productList.size) { position->

                    EachGroceryItem(productList, position, LocalContext.current,onGroceryItemClick)

                }
        } )

    }
}


/*@Composable
fun BackHandler(
    enabled: Boolean = true,
    onBack: () -> Unit,
    showCustomBackDialog: Boolean,
    backDispatcher: OnBackPressedDispatcherOwner?
){



    // Register a callback to handle back button press
  *//*  val callback = rememberUpdatedState(object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            showCustomBackDialog = true
        }
    })*//*

   *//* DisposableEffect(backDispatcher) {
        backDispatcher.addCallback(callback)
        onDispose {
            callback.remove()
        }
    }*//*


    DisposableEffect(backDispatcher) {
        val observer = LifecycleEventObserver { _, event ->
            *//* ... *//*
           // backDispatcher = callback
           // showCustomBackDialog = true
           // callback
        }

        backDispatcher?.lifecycle?.addObserver(observer)
        onDispose {
            backDispatcher?.lifecycle?.removeObserver(observer)
        }
    }


}*/




@Composable
fun EachGroceryItem(
    itemList: List<EachGroceryItemVO>,
    it: Int,
    current: Context,
    onGroceryItemClick: (EachGroceryItemVO, Int) -> Unit,
) {
    SimilarProductEachItem(Modifier,itemList[it],onGroceryItemClick)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    GroceryAppTheme {
      //  EachGroceryItemListScreen()
    }
}