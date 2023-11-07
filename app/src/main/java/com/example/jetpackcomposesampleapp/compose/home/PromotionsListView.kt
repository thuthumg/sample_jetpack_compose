package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposesampleapp.R

@Composable
fun PromotionsListView(){
    LazyRow(modifier =
    Modifier.padding(
        vertical = dimensionResource(id = R.dimen.margin_small)) )
    {
        items(6){ position ->
            //  ListItem(name = "" )
            DiscountImageView(imagePainter = painterResource(id = R.drawable.food_discount_img),
                position = position)
        }
    }
}

@Composable
private fun DiscountImageView(imagePainter: Painter, position: Int) {
    Card(
        modifier = Modifier
            .padding(
                start = if(position == 0) dimensionResource(id = R.dimen.margin_medium_2) else
                    dimensionResource(id = R.dimen.margin_medium),
                top = dimensionResource(id = R.dimen.margin_medium_2),
                end = if(position == 5) dimensionResource(id = R.dimen.margin_medium_2) else
                    dimensionResource(id = R.dimen.margin_medium),
                bottom = dimensionResource(id = R.dimen.margin_medium_2) ),
        shape = RoundedCornerShape(
            dimensionResource(id = R.dimen.dimen_card_corner_radius)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
        )
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.dimen_promotion_image_size_width_from_home))
                // .padding(16.dp)
                .height(dimensionResource(id = R.dimen.dimen_promotion_image_size_height_from_home)),
            contentScale = ContentScale.Crop
        )
    }
}