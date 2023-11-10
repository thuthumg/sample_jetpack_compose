package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.jetpackcomposesampleapp.MainViewModel
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO

@Composable
fun HomeBodyListView(
    onCategoryItemClick: (CategoryItemVO) -> Unit,
    onSeeAllClick: () -> Unit,
    viewModel: MainViewModel
) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = dimensionResource(id = R.dimen.margin_medium_2),
                        bottom = dimensionResource(id = R.dimen.margin_medium_2),)

            ) {

                CategoriesListView(onCategoryItemClick,onSeeAllClick,viewModel)
                PromotionsListView()
                PopularDealsListView()

            }

}





