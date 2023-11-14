package com.example.jetpackcomposesampleapp.compose.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.compose.category.ProductItemView
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
//import com.example.jetpackcomposesampleapp.data.vos.ProductItemVO
import com.example.jetpackcomposesampleapp.util.fontDimensionResource
import com.example.jetpackcomposesampleapp.util.productList


@Composable
fun SimilarProductsView(
    onIncreaseClickListener: ((EachGroceryItemVO) -> Unit)?,
    onDecreaseClickListener: ((EachGroceryItemVO) -> Unit)?
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.margin_card_medium_2)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimen_card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.dimen_card_elevation)
        ),

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SimilarProductTitleView()
            onIncreaseClickListener?.let {
                onDecreaseClickListener?.let { it1 ->
                    SimilarProductItemListView(
                        onIncreaseClickListener = it,
                        onDecreaseClickListener = it1
                    )
                }
            }
        }
    }

}

@Composable
private fun SimilarProductTitleView() {
    Text(
        text = stringResource(R.string.similar_products),
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium_3),
                top = dimensionResource(id = R.dimen.margin_medium_3),
                end = 0.dp,
                bottom = dimensionResource(id = R.dimen.margin_medium_2)
            )
            .fillMaxWidth(),
        color = Color.Black,
        fontSize = fontDimensionResource(id = R.dimen.text_regular_2x),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start,

        )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SimilarProductItemListView(
    onIncreaseClickListener: (EachGroceryItemVO) -> Unit,
    onDecreaseClickListener: (EachGroceryItemVO) -> Unit
) {

//    val productList: List<ProductItemVO> = listOf(
//        ProductItemVO(1,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
//        ProductItemVO(2,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
//        ProductItemVO(3,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
//        ProductItemVO(4,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
//        ProductItemVO(5,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
//        ProductItemVO(6,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
//        ProductItemVO(7,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
//        ProductItemVO(8,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
//        // ProductItemVO("Watermelon",1.6,"pc",R.drawable.watermelon_img,20)
//
//    )

    val rows = 2
    // val columns = productList.size
    FlowRow(
        maxItemsInEachRow = rows
    ) {
        val itemModifier = Modifier
            // .clip(RoundedCornerShape(4.dp))
            .weight(1f)
//rows * columns
        repeat(productList.size) {position->

            ProductItemView(
                modifier = itemModifier,
                eachProductItem = productList[position],
                onEachProductItemClick = null,
                addToCartButtonChange = null,
                changeProductItemVO = EachGroceryItemVO(
                    itemId = 0,
                    itemName = "",
                    itemImage =0,
                    itemPrice = "0.0",
                    itemUnit = "$0.00/pc",
                    itemQuantity = 0,
                    itemCategoryType = ""),// addButtonChangeUI
                onIncreaseClickListener = onIncreaseClickListener,
                onDecreaseClickListener = onDecreaseClickListener
            )
        }
    }
}
