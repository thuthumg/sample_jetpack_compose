package com.example.jetpackcomposesampleapp.compose.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor



@Preview
@Composable
fun ProductDetailInformationView(){
    ItemInformationSection()
}


@Composable
private fun ItemInformationSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(dimensionResource(R.dimen.margin_card_medium_2)),

        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimen_card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
        ),

        ) {
        Column(modifier = Modifier.padding(12.dp)) {

            ProductNameInfoSection()
            ProductUnitInfoSection()
           //ProductPriceCaloriesAndRating
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                ProductPriceInfoSection()
                ProductCaloriesInfoSection()
                ProductRatingInfoSection()
            }

            //ItemQuantityIncreaseDecrease
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ItemQuantityIncreaseSection()
                ItemQuantityCountSection()
                ItemQuantityDecreaseSection()
            }
        }
    }
}


@Composable
private fun ItemQuantityDecreaseSection() {
    Box(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(
                    dimensionResource(
                        id = R.dimen.dimen_card_corner_radius_detail_plus_minus
                    )
                )
            )
            .background(AppMainColor)
            .padding(15.dp),
    ) {
        Icon(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp),
            tint = Color.White,
            painter = painterResource(id = R.drawable.minus_icon),
            contentDescription = "Minus"
        )
    }
}

@Composable
private fun ItemQuantityCountSection() {
    Text(

        text = "1 kg",
        modifier = Modifier
            .padding(4.dp),
        color = Color.Black,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,

        )
}

@Composable
private fun ItemQuantityIncreaseSection() {
    Box(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(
                    dimensionResource(
                        id = R.dimen.dimen_card_corner_radius_detail_plus_minus
                    )
                )
            )
            .background(AppMainColor)
            .padding(15.dp),
    ) {
        Icon(
            modifier = Modifier
                .width(10.dp)
                .height(10.dp),
            tint = Color.White,
            painter = painterResource(id = R.drawable.add_icon),
            contentDescription = "Add"
        )
    }
}

@Composable
private fun ProductRatingInfoSection() {
    Row(
        horizontalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.StarOutline,
            contentDescription = null
        )
        Text(

            text = "4.5",
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )
        Text(

            text = "(257)",
            modifier = Modifier
                .padding(4.dp),
            color = Color.Gray.copy(0.5f),
            fontSize = 12.sp,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Center,

            )

    }
}

@Composable
private fun ProductCaloriesInfoSection() {
    Text(
        text = "14 Calories",
        modifier = Modifier
            .padding(4.dp),
        color = Color.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,

        )
}

@Composable
private fun ProductPriceInfoSection() {
    Text(
        text = "$17.20",
        modifier = Modifier
            .padding(4.dp),
        color = Color.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,

        )
}

@Composable
private fun ProductUnitInfoSection() {
    Text(
        text = "$17.00/kg",
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        color = Color.Black,
        fontSize = 12.sp,
        fontWeight = FontWeight.W300,
        textAlign = TextAlign.Center,

        )
}

@Composable
private fun ProductNameInfoSection() {
    Text(
        text = "Meat",
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,

        )
}