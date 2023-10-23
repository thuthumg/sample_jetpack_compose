package com.example.jetpackcomposesampleapp.compose.offer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun OfferScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor//MaterialTheme.colorScheme.background
    ){
        OfferLayout()
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferLayout() {
    Scaffold(
     containerColor = AppMainColor,
     topBar = {
         CenterAlignedTopAppBar(
             colors = TopAppBarDefaults.mediumTopAppBarColors(
                 containerColor = AppMainColor,
                 titleContentColor = Color.White
             ),
             title = {
                 Text(text = stringResource(R.string.lbl_offer),
                     maxLines = 1,
                     overflow = TextOverflow.Ellipsis)
             })
     }
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

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(20) {
                    discountListSection()
                }
            }


        }


    }

}

@Composable
private fun discountListSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(dimensionResource(id = R.dimen.margin_medium)),

        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.dimen_search_box_radius),
            topEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomStart = dimensionResource(id = R.dimen.dimen_card_corner_radius)
        ),
        colors = CardDefaults.cardColors(
            containerColor = AppBackgroundColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        ),

        ){
        Row {
            Image(painter = painterResource(R.drawable.meat_img), contentDescription = "")
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(8.dp, 0.dp, 0.dp, 0.dp),
                    textAlign = TextAlign.Start,
                    text = "30% Discount",
                    fontWeight = FontWeight.Bold,
                    color = AppMainColor,
                    fontSize = fontDimensionResource(id = R.dimen.text_heading_1x)
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp, 0.dp, 0.dp, 0.dp),
                    textAlign = TextAlign.Start,
                    text = "Order any food from app and get the discount",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = fontDimensionResource(id = R.dimen.text_regular_2x)
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp, 0.dp, 0.dp, 0.dp),
                    textAlign = TextAlign.Start,
                    text = "Order Now",
                    fontWeight = FontWeight.Bold,
                    color = AppMainColor,
                    fontSize = fontDimensionResource(id = R.dimen.text_small)
                )
            }
        }
    }

}
/*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {

    TopAppBar(title = { Text(text = "SemicolonSpace") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f)
        ))
}
*/


@Composable
@Preview
fun OfferScreenPreview() {
    OfferScreen()
}