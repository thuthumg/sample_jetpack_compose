package com.example.jetpackcomposesampleapp.compose.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.compose.category.CategoriesActivity
import com.example.jetpackcomposesampleapp.compose.detail.DetailScreenActivity
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor

@Composable
fun HomeBodyView() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    0.dp,
                    dimensionResource(id = R.dimen.margin_medium),
                    0.dp,
                    0.dp
                ),
            shape = RoundedCornerShape(
                topStart = dimensionResource(id = R.dimen.dimen_card_corner_radius),
                topEnd =  dimensionResource(id = R.dimen.dimen_card_corner_radius),
                bottomEnd = 0.dp,
                bottomStart = 0.dp),
            colors = CardDefaults.cardColors(
                containerColor = AppBackgroundColor,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
            )

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = dimensionResource(id = R.dimen.margin_medium_2),
                        bottom = dimensionResource(id = R.dimen.margin_medium_2),)

            ) {

                CategoriesListView()
                PromotionsListView()
                PopularDealsListView()
                Spacer(modifier = Modifier.height(75.dp))
            }
        }

}





