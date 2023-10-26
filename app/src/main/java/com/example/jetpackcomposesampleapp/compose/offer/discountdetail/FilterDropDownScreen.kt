package com.example.jetpackcomposesampleapp.compose.offer.discountdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.util.fontDimensionResource


@Composable
fun FilterDropDownScreen() {
    val suggestions = listOf("Lowest price", "Highest price")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Select an item") }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column(
        Modifier
            .padding(20.dp)
            .clickable {
                expanded = !expanded
            }) {

        TextButton(
            modifier = Modifier.wrapContentSize(),
            onClick = { expanded = ! expanded }
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedText,
                    fontSize = fontDimensionResource(id = R.dimen.text_regular),
                    color = Color.Black,
                    fontWeight = FontWeight.W400)

                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))

                Icon(
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    imageVector = icon,
                    tint = Color.Black,
                    contentDescription = "")
            }


        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(120.dp)
                .background(Color.White)//with(LocalDensity.current){textfieldSize.width.toDp()}
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(

                    text = { Text(text = label, color = Color.Black)},

                    onClick = {
                    selectedText = label
                    expanded = false
                })
            }
        }
    }
}
