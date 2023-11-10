package com.example.jetpackcomposesampleapp.compose.setting

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCategoryBodyView(innerPaddingValues: PaddingValues) {
    var text by remember { mutableStateOf("") }
    val maxChar = 5
    val context = LocalContext.current
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


        Column (

            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.margin_card_medium_2))
                .clickable {
                    //  onCreateCategoryClick
                },
           // horizontalAlignment = Alignment.Start,

        ){
                 Text(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(start = dimensionResource(id = R.dimen.margin_card_medium_2)),
                    text = "Category Name",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    fontSize = fontDimensionResource(id = R.dimen.text_regular)

                )

                TextField(
                    value = text,
                    onValueChange = {
                        if (it.length <= maxChar) text = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.margin_card_medium_2)),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_medium_2)),
                    leadingIcon = {
                       // Icon(Icons.Filled.Card, "", tint = Color.Gray)
                    },
                    placeholder = {
                        Text(text = "Enter category name", color = Color.Gray)
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        containerColor = AppBackgroundColor,
                        focusedIndicatorColor = Color.Transparent,
                        disabledTextColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent

                    ),
                )


            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.margin_card_medium_2),
                        top = dimensionResource(id = R.dimen.margin_card_medium_2),
                        bottom = dimensionResource(id = R.dimen.margin_card_medium_2)
                    ),
                text = "Category Image",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = fontDimensionResource(id = R.dimen.text_regular)

            )

            Card(
                modifier = Modifier
                    .width(250.dp)
                    .height(200.dp)
                    .padding(
                        start = dimensionResource(id = R.dimen.margin_medium_2),
                        end = dimensionResource(id = R.dimen.margin_medium_2),
                        bottom = dimensionResource(id = R.dimen.margin_card_medium),

                        )
                    .align(Alignment.CenterHorizontally),

                shape = RoundedCornerShape(
                    dimensionResource(id = R.dimen.dimen_card_corner_radius_detail_plus_minus)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
                )
            ){
                Icon(
                    Icons.Filled.Image, "",
                    tint = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(dimensionResource(id = R.dimen.margin_xxlarge))
                        .align(Alignment.CenterHorizontally))
            }


            Button(

                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.margin_medium))
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally),
                //.background(AppMainColor),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = AppMainColor,
                    contentColor = Color.White)

                ,onClick = {

                    //Call API
                }
            ) {
                Text(text = "Add to cart",Modifier.padding(start = 10.dp))
            }





        }


    }
}

