package com.example.jetpackcomposesampleapp.compose.home

import android.content.Context
import android.util.Log
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
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
import com.example.jetpackcomposesampleapp.MainViewModel
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor
import com.example.jetpackcomposesampleapp.util.categoriesList
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun CategoriesListView(
    onCategoryItemClick: (CategoryItemVO) -> Unit,
    onSeeAllClick: () -> Unit,
    viewModel: MainViewModel
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = dimensionResource(id = R.dimen.margin_medium_2),
                end = dimensionResource(id = R.dimen.margin_medium_2),
            ),
        shape = RoundedCornerShape(
            dimensionResource(id = R.dimen.dimen_card_corner_radius)
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {

            CategoryCardTitleView(context, onSeeAllClick)
            HorizontalDividerView()
            CategoryItemListView(onCategoryItemClick,viewModel)

        }

    }
}

@Composable
private fun CategoryCardTitleView(context: Context, onSeeAllClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                dimensionResource(id = R.dimen.margin_medium)
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        CategoryTitleView()
        SeeAllTextView(context, onSeeAllClick)

    }
}

@Composable
private fun SeeAllTextView(context: Context, onSeeAllClick: () -> Unit) {
    Text(
        modifier = Modifier
            .padding(
                start = 0.dp,
                top = dimensionResource(id = R.dimen.margin_medium),
                end = dimensionResource(id = R.dimen.margin_medium),
                bottom = 0.dp
            )
            .clickable {
                onSeeAllClick()
                // val intent = Intent(context, CategoriesActivity::class.java)
                //  context.startActivity(intent)
                // NavigationScreen(navController = navController)
            },
        textAlign = TextAlign.End,
        text = stringResource(R.string.lbl_see_all),
        fontWeight = FontWeight.W400,
        color = AppMainColor,
        fontSize = fontDimensionResource(id = R.dimen.text_regular),
    )
}

@Composable
private fun CategoryTitleView() {
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
        fontWeight = FontWeight.W600,
        color = Color.Black,
        fontSize = fontDimensionResource(id = R.dimen.text_regular_2x)
    )
}

@Composable
fun HorizontalDividerView() {

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
private fun CategoryItemListView(
    onCategoryItemClick: (CategoryItemVO) -> Unit,
    viewModel: MainViewModel
) {


  //  val posts = viewModel.posts.value

    val posts = categoriesList

    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = dimensionResource(id = R.dimen.margin_small))
    ) {
        items(posts.size) { position ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        Log.d("category", "check category id")
                        onCategoryItemClick(categoriesList[position])
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                posts[position].categoryImage?.let { it1 ->painterResource(id = it1) }
                    ?.let { CategoryImageView(imagePainter = it) }
                CategoryNameTextView(position)
            }


        }
    }

    DisposableEffect(Unit){
        viewModel.getPosts()
        onDispose {  }
    }
}

@Composable
private fun CategoryNameTextView(position: Int) {
    Text(
        modifier = Modifier.padding(
            start = 0.dp,
            top = 0.dp,
            end = 0.dp,
            bottom = dimensionResource(id = R.dimen.margin_medium_2),
        ),
        text = categoriesList[position].categoryName,
        fontSize = fontDimensionResource(id = R.dimen.text_small),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.W400,
        color = Color.Black,

        )
}

@Composable
private fun CategoryImageView(imagePainter: Painter) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.margin_medium_2))
//            .clickable {
//                mContext.startActivity(DetailScreenActivity.newIntent(mContext,false))//Intent(mContext, DetailScreenActivity::class.java)
//            }
        ,
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
                .height(dimensionResource(id = R.dimen.dimen_category_image_size_from_home)),
        )
    }
}