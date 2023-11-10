package com.example.jetpackcomposesampleapp.compose.category

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource


@Composable
fun CategoryBodyView(
    current: Context,
    innerPadding: PaddingValues,
    categoriesList: List<CategoryItemVO>,
    onCategoryItemClick: (CategoryItemVO) -> Unit
) {
    CategoriesListView(
        LocalContext.current,
        innerPadding, com.example.jetpackcomposesampleapp.util.categoriesList,onCategoryItemClick)
}


@Composable
fun CategoriesListView(
    current: Context,
    innerPadding: PaddingValues,
    categoriesList: List<CategoryItemVO>,
    onCategoryItemClick: (CategoryItemVO) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),

        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            topEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomEnd = 0.dp,
            bottomStart = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        ),


        ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.margin_medium),
                top = dimensionResource(id = R.dimen.margin_medium_2),
                end = dimensionResource(id = R.dimen.margin_medium),
                bottom = 0.dp)
        ) {
            items(categoriesList.size) {

                EachCategoryItemView(categoriesList, it,current,onCategoryItemClick)

            }
        }
    }

}

@Composable
private fun EachCategoryItemView(
    categoriesList: List<CategoryItemVO>,
    it: Int,
    current: Context,
    onCategoryItemClick: (CategoryItemVO) -> Unit
) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .padding(dimensionResource(id = R.dimen.margin_medium))
            .clickable {

                onCategoryItemClick(categoriesList[it])
            },
        colors = CardDefaults.cardColors(
            containerColor = AppSecondaryColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
        )

    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.margin_medium)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CategoryImageView(categoriesList, it)
            CategoryNameView(categoriesList, it)
        }
    }




}

@Composable
private fun CategoryNameView(
    categoriesList: List<CategoryItemVO>,
    it: Int
) {
    Text(
        text = categoriesList[it].categoryName,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.margin_medium))
            .fillMaxSize(),
        color = Color.Black,
        fontSize = fontDimensionResource(id = R.dimen.text_regular),
        fontWeight = FontWeight.W500,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis

    )
}

@Composable
private fun CategoryImageView(
    categoriesList: List<CategoryItemVO>,
    it: Int
) {
    categoriesList[it].categoryImage?.let { it1 -> painterResource(id = it1) }?.let { it2 ->
        Image(
            painter = it2,//painterResource(id = categoriesList[it].categoryImage)
            contentDescription = "",
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.dimen_category_image_size_from_home))
                .width(dimensionResource(id = R.dimen.dimen_category_image_size_from_home))
                .padding(dimensionResource(id = R.dimen.margin_medium))
        )
    }
}
