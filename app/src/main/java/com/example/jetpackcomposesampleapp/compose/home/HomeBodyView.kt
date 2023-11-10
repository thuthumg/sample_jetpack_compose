package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.MainViewModel
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor

@Composable
fun HomeBodyView(
    innerPadding: PaddingValues,
    onCategoryItemClick: (CategoryItemVO) -> Unit,
    onSeeAllClick: () -> Unit,
    viewModel: MainViewModel
) {
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
            topEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = AppBackgroundColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
        )

    ) {

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            item {

                HomeBodyListView(onCategoryItemClick, onSeeAllClick,viewModel)
            }


        }
    }
}