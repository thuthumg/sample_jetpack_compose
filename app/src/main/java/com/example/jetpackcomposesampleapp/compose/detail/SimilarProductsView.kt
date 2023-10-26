package com.example.jetpackcomposesampleapp.compose.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.ProductItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Preview
@Composable
fun SimilarProductsView() {
    SimilarProductsSection()
}

@Composable
private fun SimilarProductsSection() {
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

            SimilarProductTitleSection()
            SimilarProductItemList()

        }
    }

}

@Composable
private fun SimilarProductTitleSection() {
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
private fun SimilarProductItemList() {

    val productList: List<ProductItemVO> = listOf(
        ProductItemVO(1,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
        ProductItemVO(2,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
        ProductItemVO(3,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
        ProductItemVO(4,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
        ProductItemVO(5,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
        ProductItemVO(6,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
        ProductItemVO(7,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
        ProductItemVO(8,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
        // ProductItemVO("Watermelon",1.6,"pc",R.drawable.watermelon_img,20)

    )

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

            SimilarProductEachItem(itemModifier, productList[position], null)
        }
    }
}

@Composable
fun SimilarProductEachItem(
    modifier: Modifier,
    productItemVO: ProductItemVO,
    onGroceryItemClick: ((ProductItemVO, Int) -> Unit)?
) {
    Card(
        modifier = modifier
            .border(1.dp, Color.Gray.copy(0.1f)).clickable {
                if (onGroceryItemClick != null) {
                    onGroceryItemClick(productItemVO,1)
                }
            },
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

            ProductImageSection(productItemVO.productImage)
            ProductNameSection(productItemVO.productName)
            ProductPriceAndUnitSection(productItemVO.productUnit)
            ProductPriceAndAddButtonSection(productItemVO.productPrice)
        }
    }
}

@Composable
private fun ProductImageSection(productImage: Int) {
    Image(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.dimen_similar_product_img_width))
            .height(dimensionResource(id = R.dimen.dimen_similar_product_img_height)),
        painter = painterResource(id = productImage),
        contentDescription = null,
    )
}

@Composable
private fun ProductNameSection(productName: String) {
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
private fun ProductPriceAndUnitSection(productUnit: String) {
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
private fun ProductPriceAndAddButtonSection(productPrice: String) {
    Row(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize(),
        //horizontalArrangement = Arrangement.SpaceEvenly,
        //  verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$${productPrice}",
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.margin_medium_3),
                    top = dimensionResource(id = R.dimen.margin_card_medium),
                    end = 0.dp,
                    bottom = 0.dp
                ),

            color = AppMainColor,
            fontSize = fontDimensionResource(id = R.dimen.text_regular),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,

            )
        AddItemSection()

    }

}
@Composable
private fun AddItemSection() {
    Box(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .padding(0.dp)
                .align(Alignment.BottomEnd),// Align to the bottom right
            onClick = {
                // Action to Perform
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