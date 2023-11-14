package com.example.jetpackcomposesampleapp.compose.category

import android.util.Log
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor

@Composable
fun ProductItemListScreen(
    onBackClick: () -> Unit,
    onGroceryItemClick: (EachGroceryItemVO, Int) -> Unit,
    categoryName: String,
    categoryIdParam: String
) {


    var addButtonChangeUI  by rememberSaveable {
        mutableStateOf("")
    }
    var changeProductItemVO by remember { mutableStateOf(
        EachGroceryItemVO(
        itemId = 0,
        itemName = "",
        itemImage =0,
        itemPrice = "0.0",
        itemUnit = "$0.00/pc",
        itemQuantity = 0,
        itemCategoryType = "")) }

    val mContext = LocalContext.current
    var showCustomBackDialog by remember { mutableStateOf(false) }

    var backDispatcher = LocalOnBackPressedDispatcherOwner.current

  /*  BackHandler(true, onBack = {

    },showCustomBackDialog,backDispatcher)*/

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor
    ) {


        ProductItemListLayout(
            onBackClick,
            onGroceryItemClick,
            categoryName,
            categoryIdParam,
            addToCartButtonChange = { changeStatus, productItemVO->
               /* addButtonChangeUI = "true"
                productItemVO.selectedItemQuantity += 1
                changeProductItemVO = productItemVO*/
            },
            changeProductItemVO,
            onIncreaseClickListener = {

              /*  Log.d("ProductItemListScreen","onIncrease click listener")
                addButtonChangeUI = "true"
                it.selectedItemQuantity += 1

                Log.d("ProductItemListScreen","check selected item count = ${it.selectedItemQuantity}")
                changeProductItemVO = it
*/

            },
            onDecreaseClickListener = {
               /* addButtonChangeUI = "true"
                if(it.selectedItemQuantity <=0)
                {
                    it.selectedItemQuantity = 0
                }else{
                    it.selectedItemQuantity -= 1
                }

                changeProductItemVO = it*/
            }
        )


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItemListLayout(
    onBackClick: () -> Unit,
    onGroceryItemClick: (EachGroceryItemVO, Int) -> Unit,
    categoryName: String,
    categoryIdParam: String,
    addToCartButtonChange: (String, EachGroceryItemVO) -> Unit,
    changeProductItemVO: EachGroceryItemVO,
    onIncreaseClickListener: (EachGroceryItemVO) -> Unit,
    onDecreaseClickListener: (EachGroceryItemVO) -> Unit
) {
    Scaffold(
        containerColor = AppMainColor,
        topBar = {
           ProductsListHeaderView(onBackClick,categoryName)
        }
    ){ innerPadding->

        ProductsListBodyView(
            innerPadding,onGroceryItemClick,categoryIdParam,
            addToCartButtonChange,
            changeProductItemVO,
            onIncreaseClickListener,
            onDecreaseClickListener
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

