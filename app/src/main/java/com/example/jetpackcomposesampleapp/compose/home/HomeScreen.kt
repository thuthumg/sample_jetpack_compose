package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor

@Composable
fun HomeScreen(
    onCategoryItemClick : (CategoryItemVO)->Unit,
    onSeeAllClick : ()-> Unit
) {


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor//MaterialTheme.colorScheme.background
    ){
        HomeLayout(onCategoryItemClick,onSeeAllClick)
    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeLayout(onCategoryItemClick: (CategoryItemVO) -> Unit,
                       onSeeAllClick: () -> Unit) {
    Scaffold(
      containerColor = AppMainColor,
        topBar = {

        }
    ) { innerPadding ->
        Column {
            HomeHeaderView()
            Card(
                modifier = Modifier
                    .fillMaxSize()
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

                LazyColumn(modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                ){

                    item {

                        HomeBodyView(onCategoryItemClick,onSeeAllClick)
                    }


                }
            }
        }





//        Column(modifier = Modifier
//            .padding(innerPadding)
//            .fillMaxSize()
//            .background(AppMainColor)
//            .verticalScroll(rememberScrollState())
//        ){
//
//            HomeHeaderView()
//            HomeBodyView()
//
//        }
    }
}








