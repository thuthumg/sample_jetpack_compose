package com.example.jetpackcomposesampleapp.compose.order

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor

@Composable
fun OrderScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor// MaterialTheme.colorScheme.background
    ){
        OrderLayout()
    }


}

@OptIn(ExperimentalMaterial3Api::class)
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




        }


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