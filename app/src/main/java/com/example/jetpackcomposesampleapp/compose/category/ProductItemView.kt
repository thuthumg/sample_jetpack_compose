package com.example.jetpackcomposesampleapp.compose.category

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource


@Composable
fun ProductItemView(
    modifier: Modifier,
    eachProductItem:EachGroceryItemVO,
    onEachProductItemClick: ((EachGroceryItemVO, Int) -> Unit)?,
    addToCartButtonChange: ((String, EachGroceryItemVO) -> Unit)?,
    changeProductItemVO: EachGroceryItemVO,
    onIncreaseClickListener: (EachGroceryItemVO) -> Unit,
    onDecreaseClickListener: (EachGroceryItemVO) -> Unit
) {

    var itemCount by remember { mutableStateOf(1) }
    var stateChangeUIFlag by remember { mutableStateOf(0) }


    Card(
        modifier = modifier
            .border(1.dp, Color.Gray.copy(0.1f)),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ProductImageView(
                eachProductItem.itemImage,
                onEachProductItemClick,
                eachProductItem)

            Row(
                Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.Bottom
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    ProductNameView(eachProductItem.itemName)
                    ProductPriceAndUnitView(eachProductItem.itemUnit)
                    addToCartButtonChange?.let { ProductPriceView(
                        eachProductItem.itemPrice,

                    ) }
                }

                Column(modifier = Modifier.weight(0.5f),
                    horizontalAlignment = Alignment.End) {
                    ProductAddButtonView(
                        addToCartButtonChange =
                        {
                            stateChangeUIFlag = 1
                        },
                        changeProductItemVO,
                        eachProductItem,
                        onIncreaseClickListener = {
                            itemCount ++
                        },
                        onDecreaseClickListener = {
                            if(itemCount >1)
                            {
                                itemCount --
                            }else{
                                stateChangeUIFlag = 0
                                itemCount = 1
                            }
                        },
                        itemCount = itemCount,
                        stateChangeUIFlag = stateChangeUIFlag
                        )

                }

            }



        }
    }



}


@Composable
private fun ProductImageView(
    productImage: Int,
    onEachProductItemClick: ((EachGroceryItemVO, Int) -> Unit)?,
    eachProductItem: EachGroceryItemVO
) {
    Image(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.dimen_similar_product_img_width))
            .height(dimensionResource(id = R.dimen.dimen_similar_product_img_height))
            .clickable {
                if (onEachProductItemClick != null) {
                    onEachProductItemClick(eachProductItem, 1)
                }
            },
        painter = painterResource(id = productImage),
        contentDescription = null,
    )
}

@Composable
private fun ProductNameView(productName: String) {
    Text(
        text = productName ?: "",
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium_3),
                top = dimensionResource(id = R.dimen.margin_card_medium),
                end = 0.dp,
                bottom = 0.dp
            )
            .fillMaxWidth(),
        color = Color.Black,
        fontSize = fontDimensionResource(id = R.dimen.text_regular),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start,

        )
}

@Composable
private fun ProductPriceAndUnitView(productUnit: String) {
    Text(
        text = productUnit,
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium_3),
                top = dimensionResource(id = R.dimen.margin_card_medium),
                end = 0.dp,
                bottom = 0.dp
            )
            .fillMaxWidth(),
        color = Color.Gray.copy(0.5f),
        fontSize = fontDimensionResource(id = R.dimen.text_small),
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start,

        )
}
@Composable
private fun ProductPriceView(
    productPrice: String,
) {
    Row(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize(),
    ) {
        Text(
            text = "$${productPrice}",
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.margin_medium_3),
                    top = dimensionResource(id = R.dimen.margin_card_medium),
                    end = 0.dp,
                    bottom = dimensionResource(id = R.dimen.margin_card_medium),
                ),

            color = AppMainColor,
            fontSize = fontDimensionResource(id = R.dimen.text_regular),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,

            )


    }

}

@Composable
private fun ProductAddButtonView(
    addToCartButtonChange: (() -> Unit)?,
    changeProductItemVO: EachGroceryItemVO,
    eachGroceryItemVO: EachGroceryItemVO,
    onIncreaseClickListener:(EachGroceryItemVO) -> Unit,
    onDecreaseClickListener:(EachGroceryItemVO) -> Unit,
    itemCount: Int,
    stateChangeUIFlag : Int
) {

    Box(
        modifier = Modifier
            .padding(0.dp),
    ) {

        if(stateChangeUIFlag == 1)
        {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                   // .align(Alignment.BottomEnd),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(id = R.dimen.dimen_card_corner_radius),
                    topEnd = 0.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AppMainColor,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(R.dimen.dimen_card_elevation)
                ),

                )
            {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            dimensionResource(id = R.dimen.margin_medium)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        modifier = Modifier.clickable {
                            /*if (count > 0) {
                                count--

                            }*/
                            onDecreaseClickListener(eachGroceryItemVO)
                        },
                        imageVector = Icons.Default.Remove,
                        tint = Color.White, contentDescription = ""
                    )
                    Text(
                       // modifier = Modifier.padding(dimensionResource(id = R.dimen.margin_medium)),
                        text = itemCount.toString(),//changeProductItemVO.selectedItemQuantity.toString(),
                        fontWeight = FontWeight.W600,
                        color = Color.White,
                        fontSize = fontDimensionResource(id = R.dimen.text_regular_2x)
                    )
                    Icon(
                        modifier = Modifier.padding(
                            top = dimensionResource(id = R.dimen.margin_medium)
                        ).clickable {

                          //  count++
                           // Log.d("ProductItemView","check increase btn click listener")

                            onIncreaseClickListener(eachGroceryItemVO)
                        },
                        imageVector = Icons.Default.Add,
                        tint = Color.White, contentDescription = ""
                    )
                }
            }
        }
        else{
            Button(
                modifier = Modifier
                    .padding(0.dp),
                    //.align(Alignment.BottomEnd),// Align to the bottom right
                onClick = {
                    // Action to Perform
                    if (addToCartButtonChange != null) {
                        addToCartButtonChange()
                    }

                }, colors = ButtonDefaults.buttonColors(
                    containerColor = AppMainColor,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray.copy(0.5f),
                    disabledContentColor = Color.White
                ),
                shape = RoundedCornerShape(
                    topStartPercent = 30,
                    topEndPercent = 0,
                    bottomEndPercent = 0,
                    bottomStartPercent = 0
                ), // Can add RoundedCorner etc
                //  border = BorderStroke(width = 2.dp, color = Color.Blue),
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        tint = Color.White, contentDescription = ""
                    )
                },
                contentPadding = PaddingValues(
                    start = 2.dp,
                    top = 2.dp,
                    end = 2.dp,
                    bottom = 2.dp,
                )

            )
        }





    }
}