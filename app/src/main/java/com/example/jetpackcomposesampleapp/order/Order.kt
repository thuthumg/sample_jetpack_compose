package com.example.jetpackcomposesampleapp.order

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OrderScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        MyScaffoldLayout()
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldLayout() {
    Scaffold(
        topBar = { MyTopAppBar() }
    ) { innerPaddingValues->
        Column (modifier =
        Modifier
            .fillMaxSize()
            .padding(paddingValues = innerPaddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "PROFILE",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                // fontSize = MaterialTheme.typography.h3.fontSize,
            }
        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {

    TopAppBar(title = { Text(text = "SemicolonSpace") },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.4f)
        ))
}


@Composable
fun MyFAB(contextForToast: Context) {

}

@Composable
fun MyBottomBar(contextForToast: Context) {

}


@Composable
@Preview
fun OrderScreenPreview() {
    OrderScreen()
}