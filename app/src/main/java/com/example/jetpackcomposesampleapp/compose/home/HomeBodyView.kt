package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO

@Composable
fun HomeBodyView(onCategoryItemClick: (CategoryItemVO) -> Unit, onSeeAllClick: () -> Unit) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(
//                    0.dp,
//                    dimensionResource(id = R.dimen.margin_medium),
//                    0.dp,
//                    0.dp
//                ),
//            shape = RoundedCornerShape(
//                topStart = dimensionResource(id = R.dimen.dimen_card_corner_radius),
//                topEnd =  dimensionResource(id = R.dimen.dimen_card_corner_radius),
//                bottomEnd = 0.dp,
//                bottomStart = 0.dp),
//            colors = CardDefaults.cardColors(
//                containerColor = AppBackgroundColor,
//            ),
//            elevation = CardDefaults.cardElevation(
//                defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
//            )
//
//        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = dimensionResource(id = R.dimen.margin_medium_2),
                        bottom = dimensionResource(id = R.dimen.margin_medium_2),)

            ) {

                CategoriesListView(onCategoryItemClick,onSeeAllClick)
                PromotionsListView()
                PopularDealsListView()
               // Spacer(modifier = Modifier.height(75.dp))
            }
       // }

}





