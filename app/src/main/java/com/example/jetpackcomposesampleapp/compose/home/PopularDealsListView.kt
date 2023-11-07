package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor
import com.example.jetpackcomposesampleapp.util.categoriesList
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun PopularDealsListView() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium_2),
                end = dimensionResource(id = R.dimen.margin_medium_2),
            ),
        shape = RoundedCornerShape(
            dimensionResource(id = R.dimen.dimen_card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()

        ){

            PopularDealsTitleView()
            HorizontalDividerView()
            PopularDealsItemListView()

        }

    }
}

@Composable
private fun PopularDealsTitleView() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.margin_medium)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        PopularDealsTitleTextView()
        SeeAllTextView()

    }
}

@Composable
private fun SeeAllTextView() {
    Text(
        modifier = Modifier
            .padding(
                start = 0.dp,
                top = dimensionResource(id = R.dimen.margin_medium),
                end = dimensionResource(id = R.dimen.margin_medium),
                bottom = 0.dp
            )
            .clickable {},
        textAlign = TextAlign.End,
        text = stringResource(R.string.lbl_see_all),
        fontWeight = FontWeight.W400,
        color = AppMainColor,
        fontSize = fontDimensionResource(id = R.dimen.text_regular),
    )
}

@Composable
private fun PopularDealsTitleTextView() {
    Text(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium),
                top = dimensionResource(id = R.dimen.margin_medium),
                end = 0.dp,
                bottom = 0.dp
            ),
        textAlign = TextAlign.Start,
        text = stringResource(R.string.lbl_popular_deals),
        fontWeight = FontWeight.W600,
        color = Color.Black,
        fontSize = fontDimensionResource(id = R.dimen.text_regular_2x)
    )
}

@Composable
private fun PopularDealsItemListView(){
    LazyRow(modifier = Modifier
        .padding(vertical = dimensionResource(id = R.dimen.margin_small)) ){
        items(6){ position->

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                PopularImageView(imagePainter = painterResource(id = R.drawable.meat_img))
                PopularItemNameView()
            }


        }
    }
}

@Composable
private fun PopularItemNameView() {


    Text(
        modifier = Modifier.padding(
            start = 0.dp,
            top = 0.dp,
            end = 0.dp,
            bottom = dimensionResource(id = R.dimen.margin_medium_2),
        ),
        text = "Meat",
        fontSize = fontDimensionResource(id = R.dimen.text_small),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.W400,
        color = Color.Black,

        )

}

@Composable
private fun PopularImageView(imagePainter: Painter) {
    Card(
        modifier = Modifier
           // .width(200.dp)
            .padding(dimensionResource(id = R.dimen.margin_medium_2)),
        colors = CardDefaults.cardColors(
            containerColor = AppSecondaryColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation =  dimensionResource(id = R.dimen.dimen_card_elevation)
        )
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.dimen_popular_item_image_width_from_home))
                // .padding(16.dp)
                .height(dimensionResource(id = R.dimen.dimen_popular_item_image_height_from_home)),
            contentScale = ContentScale.Crop
        )
    }
}

