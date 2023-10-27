package com.example.jetpackcomposesampleapp.compose.offer.discountdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.compose.detail.DetailScreenActivity
//import com.example.jetpackcomposesampleapp.data.vos.DiscountItemVO
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
//import com.example.jetpackcomposesampleapp.util.discountItemVOList
import com.example.jetpackcomposesampleapp.util.fontDimensionResource
import com.example.jetpackcomposesampleapp.util.productList

@Composable
fun DiscountDetail(onDiscountItemProductClick:(EachGroceryItemVO) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor
    ) {
        DiscountDetailLayout(onDiscountItemProductClick)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DiscountDetailLayout(onDiscountItemProductClick:(EachGroceryItemVO) -> Unit) {
    Scaffold(
        containerColor = AppMainColor,
        topBar = {
            DiscountDetailTopBar()
        }
    ) { innerPaddingValues ->
        DiscountDetailContentLayout(innerPaddingValues,onDiscountItemProductClick)


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscountDetailContentLayout(innerPaddingValues: PaddingValues,onDiscountItemProductClick:(EachGroceryItemVO) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),

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
        )

    ) {

        DiscountItemListLayout(onDiscountItemProductClick)

    }
}

@Composable
fun DiscountItemListLayout(onDiscountItemProductClick:(EachGroceryItemVO) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.margin_medium)),

        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            topEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomStart = dimensionResource(id = R.dimen.dimen_card_corner_radius)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        ),

        ){
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                FilterView()
            }
            items(productList.size) { position->
                EachDiscountItemLayout(productList[position],onDiscountItemProductClick)
                if(position != (productList.size - 1))
                {
                    Divider(color = Color.Gray.copy(0.1f), thickness = 1.dp)
                }



            }
        }
    }

}

@Composable
private fun FilterView() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        verticalAlignment = Alignment.CenterVertically,
      //  horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(
                    top = 0.dp,
                    bottom = 0.dp,
                    start = dimensionResource(id = R.dimen.margin_card_medium),
                    end = 0.dp
                ),
            textAlign = TextAlign.Start,
            text = "Filter by",
            fontWeight = FontWeight.W600,
            color = Color.Gray.copy(0.5f),
            fontSize = fontDimensionResource(id = R.dimen.text_regular)
        )
        FilterDropDownScreen()
        Text(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 0.dp,
                    bottom = 0.dp,
                    start = 0.dp,
                    end =  dimensionResource(id = R.dimen.margin_card_medium),
                ),
            textAlign = TextAlign.End,
            text = "345 Results",
            fontWeight = FontWeight.W600,
            color = Color.Gray.copy(0.5f),
            fontSize = fontDimensionResource(id = R.dimen.text_regular),
           // maxLines = 1,
        )


    }
}


@Composable
fun EachDiscountItemLayout(discountItemVO: EachGroceryItemVO,onDiscountItemProductClick:(EachGroceryItemVO) -> Unit) {
    val context = LocalContext.current
    Row(
            modifier = Modifier.fillMaxSize().clickable {
               // context.startActivity(DetailScreenActivity.newIntent(context,true))
                onDiscountItemProductClick(discountItemVO)
            },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .weight(1f, fill = true)

            )

            {
                DiscountItemImageLayout(discountItemVO)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f, fill = true)
            )
            {
                DiscountItemInformationLayout(discountItemVO)
            }


        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscountDetailTopBar() {
   CenterAlignedTopAppBar(
       colors = TopAppBarDefaults.mediumTopAppBarColors(
           containerColor = AppMainColor,
           titleContentColor = Color.White
       ),
       title = {
           Text(text = "30% Discount",
               maxLines = 1,
               overflow = TextOverflow.Ellipsis,
               fontWeight = FontWeight.Bold
               )
       })
}

@Composable
private fun DiscountItemImageLayout(discountCardItemVO: EachGroceryItemVO) {

    Image(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(dimensionResource(id = R.dimen.margin_card_medium_2)),
        painter = painterResource(discountCardItemVO.itemImage),
        contentDescription = "Image",
        contentScale = ContentScale.FillBounds,
    )
}

@Composable
private fun DiscountItemInformationLayout(discountItemVO: EachGroceryItemVO) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.margin_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        DiscountNameView(discountItemVO)

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            DiscountPercentView(discountItemVO)
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.margin_medium_2)))
            OriginalPriceView(discountItemVO)
        }


    }
}

@Composable
private fun OriginalPriceView(discountItemVO: EachGroceryItemVO) {
    Text(
        modifier = Modifier
            .padding(
                top = 0.dp,
                bottom = dimensionResource(id = R.dimen.margin_medium),
                start = 0.dp,
                end = 0.dp
            ),
        textAlign = TextAlign.Start,
        text = "$${discountItemVO.itemPrice}",
        fontWeight = FontWeight.Bold,
        color = AppMainColor,
        fontSize = fontDimensionResource(id = R.dimen.text_regular)
    )
}

@Composable
private fun DiscountPercentView(discountItemVO: EachGroceryItemVO) {
    Card(
        modifier = Modifier
            .wrapContentSize(),

        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.margin_medium),
            topEnd = dimensionResource(id = R.dimen.margin_medium),
            bottomEnd = dimensionResource(id = R.dimen.margin_medium),
            bottomStart = dimensionResource(id = R.dimen.margin_medium),
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Red,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        ),


        ) {
        Text(
            modifier = Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.margin_card_medium),
                    bottom = dimensionResource(id = R.dimen.margin_card_medium),
                    start = dimensionResource(id = R.dimen.margin_medium_2),
                    end = dimensionResource(id = R.dimen.margin_medium_2),
                ),
            textAlign = TextAlign.Start,
            text ="-55% ",// "${discountItemVO.discountPercent}",
            fontWeight = FontWeight.W400,
            color = Color.White,
            fontSize = fontDimensionResource(id = R.dimen.text_small)
        )
    }
}

@Composable
private fun DiscountNameView(discountItemVO: EachGroceryItemVO) {
    Text(
        modifier = Modifier
            .padding(
                top = 0.dp,
                bottom = dimensionResource(id = R.dimen.margin_medium),
                start = 0.dp,
                end = 0.dp
            ),
        textAlign = TextAlign.Start,
        text = "${discountItemVO.itemName}",
        fontWeight = FontWeight.W600,
        color = Color.Black,
        fontSize = fontDimensionResource(id = R.dimen.text_regular_2x)
    )
}
