package com.example.jetpackcomposesampleapp.compose.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun SettingBodyView(innerPaddingValues: PaddingValues, onCreateCategoryClick: ()-> Unit) {
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


        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.margin_medium_2))
        ) {

            Card(
                modifier = Modifier
                    .height(50.dp)
                    .padding(
                        start = dimensionResource(id = R.dimen.margin_medium_2),
                        end = dimensionResource(id = R.dimen.margin_medium_2),
                        bottom = dimensionResource(id = R.dimen.margin_card_medium),

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
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(id = R.dimen.margin_medium))
                        .clickable {
                            onCreateCategoryClick()
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(Icons.Filled.AddCircleOutline, "category add", tint = AppMainColor)

                    Text(
                        text = "Create Category",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        color = AppMainColor,
                        fontSize = fontDimensionResource(id = R.dimen.text_regular)

                    )
                }
            }
            Card(
                modifier = Modifier
                    .height(50.dp)
                    .padding(
                        start = dimensionResource(id = R.dimen.margin_medium_2),
                        end = dimensionResource(id = R.dimen.margin_medium_2),
                        bottom = dimensionResource(id = R.dimen.margin_card_medium),

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
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(id = R.dimen.margin_medium))
                        .clickable {
                            onCreateCategoryClick()
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(Icons.Filled.AddCircleOutline, "category add", tint = AppMainColor)

                    Text(
                        text = "Create Product Item",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold,
                        color = AppMainColor,
                        fontSize = fontDimensionResource(id = R.dimen.text_regular)

                    )
                }
            }


        }


    }
}