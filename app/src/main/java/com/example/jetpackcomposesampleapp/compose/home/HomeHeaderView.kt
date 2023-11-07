package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun HomeHeaderView() {
    Column {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            WelcomeTextView()
            ProfileView()

        }
        SearchBarView()
    }

}

@Composable
private fun WelcomeTextView() {
    Column(
        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.margin_medium)),
    ) {
        Text(
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.margin_medium_2),
                top = dimensionResource(R.dimen.margin_medium_2),
                0.dp,
                0.dp
            ),
            textAlign = TextAlign.Start,
            text = stringResource(R.string.lbl_hello),
            fontWeight = FontWeight.W600,
            color = Color.White,
            fontSize = fontDimensionResource(id = R.dimen.text_regular_2x)
        )
        Text(
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.margin_medium_2),
                top = 0.dp,
                end = 0.dp,
                bottom = 0.dp
            ),
            textAlign = TextAlign.Start,
            text = stringResource(R.string.lbl_lets_search_your_grocery_food),
            fontWeight = FontWeight.W600,
            color = Color.White,
            fontSize = fontDimensionResource(id = R.dimen.text_regular_2x)
        )
    }
}

@Composable
private fun ProfileView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = dimensionResource(id = R.dimen.margin_medium_2)),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            painter = painterResource(R.drawable.sample_profile),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.dimen_profile_size))
                .clip(CircleShape)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBarView() {

    var text by remember { mutableStateOf("") }
    val maxChar = 5

    Column {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxChar) text = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_medium_2)),
            leadingIcon = {
                Icon(Icons.Filled.Search, "", tint = Color.Gray)
            },
            placeholder = {
                Text(text = "Search your daily grocery food ...", color = Color.Gray)
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                disabledTextColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent

            ),
        )
    }
}
