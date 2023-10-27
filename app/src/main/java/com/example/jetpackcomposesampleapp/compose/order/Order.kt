package com.example.jetpackcomposesampleapp.compose.order

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipColors
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.compose.cart.CustomButton
import com.example.jetpackcomposesampleapp.data.vos.OrderItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.orderItemList
import com.example.jetpackcomposesampleapp.util.productList

@Composable
fun OrderScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor// MaterialTheme.colorScheme.background
    ){
        OrderLayout()
    }


}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun OrderLayout() {
    Scaffold(
        containerColor = AppMainColor,
        topBar = { OrderTopAppBar() }
    ) { innerPaddingValues->

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
            ),

            ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.margin_medium)),

                // shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
                colors = CardDefaults.cardColors(
                    containerColor = AppBackgroundColor,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
                ),


                ) {
                Column {
                    OrderStatusListView()
                    OrderListView()
                }

            }


        }


    }

}

@Composable
private fun OrderListView() {
    LazyColumn(modifier = Modifier.padding(dimensionResource(id = R.dimen.margin_medium))) {
        items(orderItemList.size) {
            OrderItemListLayout(orderItemList[it])
        }

    }
}

@Composable
private fun OrderStatusListView() {
    LazyRow(modifier = Modifier.padding(dimensionResource(id = R.dimen.margin_medium))) {
        items(5) {
            if(it == 0)
            ChipItem("Pending",true)
            else
                ChipItem("Pending",false)
        }

    }
}

@Composable
private fun OrderItemListLayout(orderItemVO: OrderItemVO) {
 /*   Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.margin_medium)),

        // shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
        ),


        ) {*/

        Row(
            modifier = Modifier
                .fillMaxSize().background(Color.White),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically


        ) {
            OrderImageView(orderItemVO)

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center,


                ) {

                OrderImageName()
                OrderPrice()

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = dimensionResource(id = R.dimen.margin_medium)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween


                ) {
                    OrderItemStatusView()
                    OrderDateView()

                }
            }



        }
    Divider(color = Color.Gray.copy(0.1f), thickness = 1.dp)




   // }
}

@Composable
private fun OrderDateView() {
    Text(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.margin_medium)),
        textAlign = TextAlign.Center,
        text = "23 Jan, 2020",
        fontWeight = FontWeight.Bold,
        color = Color.Gray.copy(0.5f),
        fontSize = 12.sp
    )
}

@Composable
private fun OrderItemStatusView() {
    Box(
        modifier = Modifier
            .wrapContentSize()

            .clip(
                RoundedCornerShape(
                    dimensionResource(id = R.dimen.margin_medium)
                )
            )
            .background(AppBackgroundColor)
    )
    {
        Text(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.margin_medium)),
            textAlign = TextAlign.Center,
            text = "Processing",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun OrderPrice() {
    Text(
        modifier = Modifier
            .padding(
                top = dimensionResource(id = R.dimen.margin_medium),
                start = dimensionResource(id = R.dimen.margin_medium),
                end = 0.dp,
                bottom = 0.dp),
        textAlign = TextAlign.Start,
        text = "$17.00",
        fontWeight = FontWeight.Bold,
        color = AppMainColor,
        fontSize = 12.sp
    )
}

@Composable
private fun OrderImageName() {
    Text(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium),
                top = 0.dp,
                bottom = 0.dp,
                end = 0.dp),
        textAlign = TextAlign.Start,
        text = "Strawberry(1KG)",
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontSize = 16.sp
    )
}

@Composable
private fun OrderImageView(orderItemVO: OrderItemVO) {
    Image(

        painter = painterResource(id = orderItemVO.orderItemImage),
        contentDescription = "Javascript",
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .padding(5.dp)
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipItem(text: String,selectedStatus:Boolean) {
    Chip(
        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.margin_medium)),
        onClick = {},
        leadingIcon = {},
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_medium)),
        colors = ChipDefaults.chipColors(
            backgroundColor = if(selectedStatus) AppMainColor else Color.White )
       // border = BorderStroke(0.dp, Color(0xFF3B3A3C))
    ) {
        Text(modifier = Modifier.padding(
            dimensionResource(id = R.dimen.margin_medium)),
            text = text, color = if(selectedStatus) Color.White else Color.Black)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderTopAppBar() {

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = AppMainColor,
            titleContentColor = Color.White
        ),
        title = {
            Text(
                text = stringResource(R.string.lbl_order),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        })
}

@Composable
@Preview
fun OrderScreenPreview() {
    OrderScreen()
}