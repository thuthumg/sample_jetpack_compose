package com.example.jetpackcomposesampleapp.compose.setting

import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.DiscountCardItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun SettingsScreen( onCreateCategoryClick: ()-> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor//MaterialTheme.colorScheme.background
    ){
        SettingLayout(onCreateCategoryClick)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingLayout( onCreateCategoryClick: ()-> Unit) {
    Scaffold(
        containerColor = AppMainColor,
        topBar = {
            SettingHeaderView()
        }
    ) { innerPaddingValues->
        SettingBodyView(innerPaddingValues, onCreateCategoryClick)


    }
}




@Composable
@Preview
fun SettingsScreenPreview() {
  //  SettingsScreen()
}