package com.example.jetpackcomposesampleapp.compose.category

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
import com.example.jetpackcomposesampleapp.util.productList

@Composable
fun ProductsListBodyView(
    innerPadding: PaddingValues,
    onGroceryItemClick: (EachGroceryItemVO, Int) -> Unit,
    categoryIdParam: String,
    addToCartButtonChange: (String,EachGroceryItemVO) -> Unit,
    changeProductItemVO: EachGroceryItemVO,

    onIncreaseClickListener : (EachGroceryItemVO) -> Unit,
    onDecreaseClickListener : (EachGroceryItemVO) -> Unit
) {

    ProductsListView(
        innerPadding,
        onGroceryItemClick,
        categoryIdParam,
        addToCartButtonChange,
        changeProductItemVO,
        onIncreaseClickListener ,
        onDecreaseClickListener
    )

}

@Composable
private fun ProductsListView(
    innerPadding: PaddingValues,
    onGroceryItemClick: (EachGroceryItemVO, Int) -> Unit,
    categoryIdParam: String,
    addToCartButtonChange: (String,EachGroceryItemVO) -> Unit,
    changeProductItemVO: EachGroceryItemVO,
    onIncreaseClickListener : (EachGroceryItemVO) -> Unit,
    onDecreaseClickListener : (EachGroceryItemVO) -> Unit
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

                var listdata = productList.filter { it.itemCategoryType == categoryIdParam }

                items(listdata.size) { position->

                    ProductItemView(
                        modifier = Modifier,
                        eachProductItem = listdata[position],
                        onEachProductItemClick = onGroceryItemClick,
                        addToCartButtonChange = addToCartButtonChange,
                        changeProductItemVO = changeProductItemVO,
                        onIncreaseClickListener = onIncreaseClickListener,
                        onDecreaseClickListener = onDecreaseClickListener)

                }
            } )

    }
}




