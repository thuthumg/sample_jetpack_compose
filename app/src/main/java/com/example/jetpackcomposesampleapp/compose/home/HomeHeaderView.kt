package com.example.jetpackcomposesampleapp.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun HomeHeaderView() {
    Column {
        Text(
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.margin_medium_2),
                top = dimensionResource(R.dimen.margin_medium_2),
                0.dp,
                0.dp),
            textAlign = TextAlign.Start,
            text = stringResource(R.string.lbl_hello),
            fontWeight = FontWeight.W300,
            color = Color.White,
            fontSize = fontDimensionResource(id = R.dimen.text_regular_3x)
        )
        Text(
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.margin_medium_2),
                top = 0.dp,
                end = 0.dp,
                bottom = 0.dp),
            textAlign = TextAlign.Start,
            text = stringResource(R.string.lbl_lets_search_your_grocery_food),
            fontWeight = FontWeight.W300,
            color = Color.White,
            fontSize = fontDimensionResource(id = R.dimen.text_regular_3x)
        )
        SearchBar()
    }

}

@Composable
private fun SearchBar() {

    var isFocused by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }


    Card(
        modifier = Modifier
            .padding(dimensionResource(R.dimen.margin_medium_2))
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.dimen_search_box_height))
            .padding(
                start = 0.dp,
                top = dimensionResource(R.dimen.margin_medium_2),
                end = 0.dp,
                bottom = 0.dp),
        shape = RoundedCornerShape(dimensionResource(R.dimen.dimen_search_box_radius)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.dimen_card_elevation)
        )

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.margin_card_medium_2)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                tint = Color.Black,
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 8.dp)
            )
            /*  TextField(
                  value = query,
                  onValueChange = { newText ->
                      query = newText
                  },
                  textStyle = TextStyle(
                      fontSize = 16.sp,

                      ),
                  keyboardOptions = KeyboardOptions.Default.copy(
                      imeAction = ImeAction.Done
                  ),
                  keyboardActions = KeyboardActions(
                      onDone = {
                          // Perform search or any other action here
                          isFocused = false
                      }
                  ),
                  singleLine = true,
                  modifier = Modifier.fillMaxWidth()
                      .background(Color.White),
                  placeholder = { Text("Enter Email") },



              )*/
            BasicTextField(
                value = query,
                onValueChange = { newText ->
                    query = newText
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,

                    ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Perform search or any other action here
                        isFocused = false
                    }
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),

//                onFocusChanged = { focused ->
//                    isFocused = focused
//                }
            )
        }
    }
}