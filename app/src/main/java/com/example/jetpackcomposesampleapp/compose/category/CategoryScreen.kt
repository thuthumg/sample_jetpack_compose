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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor
import com.example.jetpackcomposesampleapp.util.categoriesList
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun CategoryScreen(
    onBackClick : ()-> Unit,
    onCategoryItemClick : (CategoryItemVO)->Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor,

        ) {
            CategoryLayout(onBackClick,onCategoryItemClick)
    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryLayout(onBackClick: () -> Unit, onCategoryItemClick: (CategoryItemVO) -> Unit) {
    Scaffold(
        containerColor = AppMainColor,
        topBar = {
            CategoryHeaderView(onBackClick)
        }
    ) { innerPadding ->
        
        CategoryBodyView(LocalContext.current,
            innerPadding, categoriesList,onCategoryItemClick)

    }
}


@Composable
@Preview
fun CategoryPagePreview() {
   // CategoriesScreen()

}
