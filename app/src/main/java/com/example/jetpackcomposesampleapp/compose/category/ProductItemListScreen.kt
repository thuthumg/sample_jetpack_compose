package com.example.jetpackcomposesampleapp.compose.category

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
//import com.example.jetpackcomposesampleapp.data.vos.ProductItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItemListScreen(
    onBackClick: () -> Unit,
    onGroceryItemClick: (EachGroceryItemVO, Int) -> Unit,
    categoryName: String,
    categoryIdParam: String
) {
    val mContext = LocalContext.current
    var showCustomBackDialog by remember { mutableStateOf(false) }

    var backDispatcher = LocalOnBackPressedDispatcherOwner.current

  /*  BackHandler(true, onBack = {

    },showCustomBackDialog,backDispatcher)*/

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor
    ) {

        ProductItemListLayout(onBackClick,onGroceryItemClick,categoryName,categoryIdParam)


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItemListLayout(
    onBackClick: () -> Unit,
    onGroceryItemClick: (EachGroceryItemVO, Int) -> Unit,
    categoryName: String,
    categoryIdParam: String
) {
    Scaffold(
        containerColor = AppMainColor,
        topBar = {
           ProductsListHeaderView(onBackClick,categoryName)
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
        ProductsListBodyView(
            innerPadding,onGroceryItemClick,categoryIdParam
        )



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

