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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.compose.category.modal.CategoryModal
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor
import com.example.jetpackcomposesampleapp.util.categoriesList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen() {
    // on below line we are creating and initializing our array list
    val navController = rememberNavController()

    // on below line we are specifying theme as scaffold.
    Scaffold(
        containerColor = AppMainColor,

        //  modifier = Modifier.fillMaxSize(), // in scaffold we are specifying top bar.
        topBar = {
            // inside top bar we are specifying background color.
            CenterAlignedTopAppBar(
                // modifier = Modifier.fillMaxHeight(),
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = AppMainColor,
                    titleContentColor = Color.White
                ),
                // along with that we are specifying title for our top bar.
                title = {
                    // in the top bar we are specifying tile as a text
                    Text(
                        // on below line we are specifying
                        // text to display in top app bar.
                        text = "Categories",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis

                        // on below line we are specifying
                        // modifier to fill max width.
                     /*   modifier = Modifier.fillMaxWidth(),

                        // on below line we are specifying text alignment.
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold*/

                        // on below line we are specifying color for our text.
                        // color = Color.White
                    )
                },
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
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }


            )

        }
    ) { innerPadding ->


        // on below line we are calling grid
        // view method to load our grid view.
        categoryGridLayout(LocalContext.current, innerPadding, categoriesList)
    }


}

@Composable
fun categoryGridLayout(
    current: Context,
    innerPadding: PaddingValues,
    categoriesList: List<CategoryModal>
) {
    // on below line we are adding lazy
    // vertical grid for creating a grid view.
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(innerPadding),

        shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),


        ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(8.dp, 16.dp, 8.dp, 0.dp)
        ) {
            items(categoriesList.size) {
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp, 8.dp, 8.dp, 8.dp)
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
                        defaultElevation = 8.dp
                    )

                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = categoriesList[it].categoryImage),
                            contentDescription = "Javascript",
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .padding(5.dp)
                        )
                        Spacer(modifier = Modifier.height(9.dp))
                        Text(
                            text = categoriesList[it].categoryName,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize(),
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.W600,
                            textAlign = TextAlign.Center,

                            )
                    }
                }
            }
        }
    }

}


@Composable
@Preview
fun CategoryPagePreview() {
    CategoriesScreen()

}