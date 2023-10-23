package com.example.jetpackcomposesampleapp.compose.category
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.CategoryModal
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor
import com.example.jetpackcomposesampleapp.util.categoriesList
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen() {
    val navController = rememberNavController()
    Scaffold(
        containerColor = AppMainColor,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = AppMainColor,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = stringResource(id = R.string.lbl_categories),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
//                navigationIcon = {
//                    if (navController.previousBackStackEntry != null) {
//                       // run {
//                            IconButton(onClick = { navController.navigateUp() }) {
//                                Icon(
//                                    imageVector = Icons.Filled.ArrowBackIos,
//                                    tint = Color.White,
//                                    contentDescription = "Back"
//                                )
//
//                            }
//                       // }
//                    } else {
//                        null
//                    }
//                }
                navigationIcon =
                /*{
                    if(navController.previousBackStackEntry != null){
                        IconButton(onClick = { navController.navigateUp()}) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    } else {
                        null
                    }
                }*/

                {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Filled.ArrowBackIos, tint = Color.White, contentDescription = "Back")
                    }
                }


            )

        }
    ) { innerPadding ->
        categoryGridLayout(LocalContext.current, innerPadding, categoriesList)
    }


}

@Composable
fun categoryGridLayout(
    current: Context,
    innerPadding: PaddingValues,
    categoriesList: List<CategoryModal>
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
                
              EachCategoryItemSection(categoriesList, it,current)
                
            }
        }
    }

}

@Composable
private fun EachCategoryItemSection(
    categoriesList: List<CategoryModal>,
    it: Int,
    current: Context
) {

    Card(
        modifier = Modifier
            .fillMaxHeight()
            .padding(dimensionResource(id = R.dimen.margin_medium))
            .clickable {
                Toast
                    .makeText(
                        current,
                        categoriesList[it].categoryName + " selected..",
                        Toast.LENGTH_SHORT
                    )
                    .show()
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
            CategoryImageSection(categoriesList, it)           
            CategoryNameSection(categoriesList, it)
        }
    }
    
    
    
  
}

@Composable
private fun CategoryNameSection(
    categoriesList: List<CategoryModal>,
    it: Int
) {
    Text(
        text = categoriesList[it].categoryName,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.margin_medium))
            .fillMaxSize(),
        color = Color.Black,
        fontSize = fontDimensionResource(id = R.dimen.text_regular),
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis

        )
}

@Composable
private fun CategoryImageSection(
    categoriesList: List<CategoryModal>,
    it: Int
) {
    Image(
        painter = painterResource(id = categoriesList[it].categoryImage),
        contentDescription = "",
        modifier = Modifier
            .height(50.dp)
            .width(50.dp)
            .padding(dimensionResource(id = R.dimen.margin_medium))
    )
}


@Composable
@Preview
fun CategoryPagePreview() {
    CategoriesScreen()

}
