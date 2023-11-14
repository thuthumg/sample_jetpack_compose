package com.example.jetpackcomposesampleapp.compose.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

@Composable
fun DetailScreen(pageState:Boolean,onBackClick: ()-> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        DetailLayout(pageState,onBackClick)
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailLayout(pageState: Boolean, onBackClick: () -> Unit) {
    Scaffold(
        content = { innerPadding ->
            DetailBodyView(innerPadding,pageState,onBackClick)
        }
    )
}

