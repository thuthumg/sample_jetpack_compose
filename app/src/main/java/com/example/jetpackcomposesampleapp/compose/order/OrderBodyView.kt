package com.example.jetpackcomposesampleapp.compose.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.OrderItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.orderItemList


@Composable
fun OrderBodyView(innerPaddingValues: PaddingValues) {
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

@Composable
private fun OrderListView() {
    LazyColumn(modifier = Modifier.padding(dimensionResource(id = R.dimen.margin_medium))) {
        items(orderItemList.size) {
            OrderItemListView(orderItemList[it])
        }

    }
}

@Composable
private fun OrderStatusListView() {
    LazyRow(modifier = Modifier.padding(dimensionResource(id = R.dimen.margin_medium))) {
        items(5) {
            if(it == 0)
                ChipItemView("Pending",true)
            else
                ChipItemView("Pending",false)
        }

    }
}

@Composable
private fun OrderItemListView(orderItemVO: OrderItemVO) {
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
            .fillMaxSize()
            .background(Color.White),
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

            OrderItemNameView()
            OrderPriceView()

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
private fun OrderPriceView() {
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
private fun OrderItemNameView() {
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
private fun ChipItemView(text: String, selectedStatus:Boolean) {
    Chip(
        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.margin_medium)),
        onClick = {},
        leadingIcon = {},
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_medium)),
        colors = ChipDefaults.chipColors(
            backgroundColor = if(selectedStatus) AppMainColor else Color.White )
        // border = BorderStroke(0.dp, Color(0xFF3B3A3C))
    ) {

        Text(
            modifier = Modifier.padding(
            dimensionResource(id = R.dimen.margin_medium)),
            text = text,
            color = if(selectedStatus) Color.White else Color.Black,
          //  fontSize = dimensionResource(id = R.dimen.text_regular)
        )
    }
}

