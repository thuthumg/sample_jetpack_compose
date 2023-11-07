package com.example.jetpackcomposesampleapp.compose.setting

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor

@Composable
fun CreateCategoryScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor//MaterialTheme.colorScheme.background
    ) {
        CreateCategoryLayout()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCategoryLayout() {
   Scaffold(
        containerColor = AppMainColor,
        topBar = {
            CreateCategoryHeaderView()
        }
    ) { innerPaddingValues ->
       CreateCategoryBodyView(innerPaddingValues)


    }
}

