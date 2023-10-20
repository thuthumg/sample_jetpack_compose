package com.example.jetpackcomposesampleapp.compose.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.compose.category.CategoriesActivity
import com.example.jetpackcomposesampleapp.compose.detail.DetailScreenActivity
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor
import com.example.jetpackcomposesampleapp.util.categoriesList
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun CategoriesListView() {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium_2),
                end = dimensionResource(id = R.dimen.margin_medium_2),)
        ,
        shape = RoundedCornerShape(
            dimensionResource(id = R.dimen.dimen_card_corner_radius)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation =  dimensionResource(id = R.dimen.dimen_card_elevation),
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
        ){

            CategoryCardTitleSection(context)
            HorizontalDivider()
            CategoryItemListSection()

        }

    }
}

@Composable
private fun CategoryCardTitleSection(context: Context) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                dimensionResource(id = R.dimen.margin_medium)
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        CategoryTitleSection()
        SeeAllSection(context)

    }
}

@Composable
private fun SeeAllSection(context: Context) {
    Text(
        modifier = Modifier
            .padding(
                start = 0.dp,
                top = dimensionResource(id = R.dimen.margin_medium),
                end = dimensionResource(id = R.dimen.margin_medium),
                bottom = 0.dp
            )
            .clickable {

                val intent = Intent(context, CategoriesActivity::class.java)
                context.startActivity(intent)
                // NavigationScreen(navController = navController)
            },
        textAlign = TextAlign.End,
        text = stringResource(R.string.lbl_see_all),
        fontWeight = FontWeight.W600,
        color = AppMainColor,
        fontSize = fontDimensionResource(id = R.dimen.text_regular_2x),
    )
}

@Composable
private fun CategoryTitleSection() {
    Text(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium),
                top = dimensionResource(id = R.dimen.margin_medium),
                end = 0.dp,
                bottom = 0.dp
            ),
        textAlign = TextAlign.Start,
        text = stringResource(R.string.lbl_categories),
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontSize = fontDimensionResource(id = R.dimen.text_regular_custom)
    )
}

@Composable
fun HorizontalDivider() {

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                dimensionResource(id = R.dimen.margin_medium_2),
                0.dp,
                dimensionResource(id = R.dimen.margin_medium_2),
                0.dp
            )
            .height(height = 1.dp)
            .background(color = Color.Black.copy(alpha = 0.1f))
    )

}
@Composable
private fun CategoryItemListSection(){
    LazyRow(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = dimensionResource(id = R.dimen.margin_small)) ){
        items(categoriesList.size){ position->

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CategoryImageSection(imagePainter = painterResource(id = categoriesList[position].categoryImage))
                CategoryNameSection(position)
            }


        }
    }
}

@Composable
private fun CategoryNameSection(position: Int) {
    Text(
        modifier = Modifier.padding(
            start = 0.dp,
            top = 0.dp,
            end = 0.dp,
            bottom = dimensionResource(id = R.dimen.margin_medium_2),
        ),
        text = categoriesList[position].categoryName,
        fontSize = fontDimensionResource(id = R.dimen.text_regular),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.W600,
        color = Color.Black,

        )
}

@Composable
private fun CategoryImageSection(imagePainter: Painter) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.margin_medium_2))
            .clickable {
                mContext.startActivity(Intent(mContext, DetailScreenActivity::class.java))
            },
        colors = CardDefaults.cardColors(
            containerColor = AppSecondaryColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
        )
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.margin_medium_2))
                .height(50.dp),
        )
    }
}