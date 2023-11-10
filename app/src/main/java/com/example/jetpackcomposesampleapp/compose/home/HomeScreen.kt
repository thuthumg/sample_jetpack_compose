package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcomposesampleapp.MainViewModel

import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor

@Composable
fun HomeScreen(
    onCategoryItemClick: (CategoryItemVO) -> Unit,
    onSeeAllClick: () -> Unit,
    viewModel: MainViewModel
) {


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor//MaterialTheme.colorScheme.background
    ){
        HomeLayout(onCategoryItemClick,onSeeAllClick,viewModel)
    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeLayout(
    onCategoryItemClick: (CategoryItemVO) -> Unit,
    onSeeAllClick: () -> Unit,
    viewModel: MainViewModel
) {
    Scaffold(
      containerColor = AppMainColor
    ) { innerPadding ->
        Column {
            HomeHeaderView()
            HomeBodyView(innerPadding, onCategoryItemClick, onSeeAllClick,viewModel)
        }

    }
}










