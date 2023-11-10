package com.example.jetpackcomposesampleapp.compose.category

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryHeaderView(onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = AppMainColor,
            titleContentColor = Color.White
        ),
        title = {

            Text(
                text = stringResource(id = R.string.lbl_categories),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = fontDimensionResource(id = R.dimen.text_regular_3x)

            )
        },
        navigationIcon =
        {
            IconButton(onClick = { onBackClick() }) {
                Icon(imageVector = Icons.Filled.ArrowBackIos, tint = Color.White, contentDescription = "Back")
            }
        }


    )
}