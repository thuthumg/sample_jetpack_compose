package com.example.jetpackcomposesampleapp.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleapp.category.CategoriesActivity

import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.ui.theme.AppSecondaryColor
val headerHeight = 200.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
  //  val navController1 = rememberNavController()
    val headerHeightPx = with(LocalDensity.current) { headerHeight.toPx() }



    Scaffold(
        modifier = Modifier.fillMaxSize(),

    ) {

            innerPadding ->



        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(AppMainColor)
            .verticalScroll(rememberScrollState())){
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight)){
                Column() {
                    Text(
                        modifier = Modifier.padding(16.dp,16.dp,0.dp,0.dp),
                        textAlign = TextAlign.Start,
                        text = "Hello",
                        fontWeight = FontWeight.W300,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(
                        modifier = Modifier.padding(16.dp,0.dp,0.dp,0.dp),
                        textAlign = TextAlign.Start,
                        text = "Lets search your grocery food",
                        fontWeight = FontWeight.W300,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                    SearchBar()
                    //  BodyUI()
                }
                /*    Box(
                        Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color(0xAA000000)),
                                    startY = 3 * headerHeightPx / 4 // to wrap the title only
                                )
                            )
                    )*/
            }

            BodyUI()

        }

    }



}

@Composable
fun BodyUI() {
    Column {
        Spacer(modifier =Modifier.height(headerHeight))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp, 0.dp, 0.dp),

            shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
            colors = CardDefaults.cardColors(
                containerColor = AppBackgroundColor,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                   // .verticalScroll(rememberScrollState())

            ) {

                CategoryUI()

                RecyclerViewForDiscount()

                PopularDeals()

                Spacer(modifier = Modifier.height(75.dp))
            }
        }
    }
}

@Composable
fun CategoryUI() {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.fillMaxHeight()
            .height(250.dp)
            .padding(8.dp)
            .height(70.dp)
            .padding(0.dp, 8.dp, 0.dp, 0.dp),
        // .border(2.dp, Color.White, radius)
        // .background(Color.White, shape),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight(),
           // verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


//,
//                verticalAlignment = Alignment.CenterVertically

                Text(
                    modifier = Modifier
                        .padding(8.dp,8.dp,0.dp,0.dp),
                    textAlign = TextAlign.Start,
                    text = "Categories",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp
                )


               // Spacer(modifier = Modifier.width(20.dp))

                Text(
                    modifier = Modifier
                        .padding(0.dp, 8.dp, 8.dp, 0.dp)
                        .clickable {


                            val intent = Intent(context, CategoriesActivity::class.java)
                            context.startActivity(intent)
                            // NavigationScreen(navController = navController)
                        },
                    textAlign = TextAlign.End,
                    text = "See all",
                    fontWeight = FontWeight.W600,
                    color = AppMainColor,
                    fontSize = 16.sp
                )

            }

            HorizontalDivider()
            RecyclerView()

        }

   }
}

@Composable
fun PopularDeals() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.fillMaxHeight()
            .height(235.dp)
            .padding(8.dp)
            .height(70.dp)
            .padding(0.dp, 8.dp, 0.dp, 0.dp),
        // .border(2.dp, Color.White, radius)
        // .background(Color.White, shape),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight(),
           // verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {


//,
//                verticalAlignment = Alignment.CenterVertically

                Text(
                    modifier = Modifier
                        .padding(8.dp,8.dp,0.dp,0.dp),
                    textAlign = TextAlign.Start,
                    text = "Popular deals",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp
                )


                // Spacer(modifier = Modifier.width(20.dp))

                Text(
                    modifier = Modifier
                        .padding(0.dp,8.dp,8.dp,0.dp),
                    textAlign = TextAlign.End,
                    text = "See all",
                    fontWeight = FontWeight.W600,
                    color = AppMainColor,
                    fontSize = 16.sp
                )

            }

            HorizontalDivider()
            RecyclerViewForPopular()

        }

    }
}
@Composable
fun RecyclerViewForDiscount(){
    LazyRow(modifier = Modifier.padding(vertical = 4.dp) ){
        items(6){
            //  ListItem(name = "" )
            CardWithImageDiscount(imagePainter = painterResource(id = R.drawable.food_discount_img))
        }
    }
}

@Composable
fun HorizontalDivider() {

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
            .height(height = 1.dp)
            .background(color = Color.Black.copy(alpha = 0.1f))
    )

}

//@Composable
//@Preview
//fun HomeScreenPreview() {
//    HomeScreen()
//
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(

) {

  //  val shape = CircleShape
    var isFocused by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }


    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(70.dp)
            .padding(0.dp, 16.dp, 0.dp, 0.dp),
           // .border(2.dp, Color.White, radius)
           // .background(Color.White, shape),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
           // .padding(16.dp)
       /* modifier =
        Modifier
            .fillMaxWidth()
            .height(56.dp)
           // .background(Color.White)
            .padding(10.dp)
            .border(
                width = 1.dp,
                color = if (isFocused) Color.Blue else Color.Gray,
                shape = RoundedCornerShape(4.dp)
            )*/
           // .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
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


//@Composable
//fun ListItem(name:String){
//
//    Column (
////        modifier = Modifier
////        // .padding(24.dp)
////        .fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//
//
//
//    Card(
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxSize()
//            .padding(0.dp, 0.dp, 0.dp, 0.dp),
//        // .border(2.dp, Color.White, radius)
//        // .background(Color.White, shape),
//        shape = RoundedCornerShape(10.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = AppSecondaryColor,
//        ),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 10.dp
//        )
//    )
//    {
//
//        /* Card(
//        color = AppSecondaryColor,
//        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))*/
//
//
//            Image(
//                modifier = Modifier.padding(8.dp),
//                painter = painterResource(id = R.drawable.vegetable),
//                contentDescription = "Vegetable Image"
//            )
//
//
//        }
//
//        Text(
//            // modifier = Modifier.padding(16.dp,16.dp,0.dp,0.dp),
//            textAlign = TextAlign.Center,
//            text = "Vegatables",
//            fontWeight = FontWeight.W500,
//            color = Color.Black,
//            fontSize = 12.sp
//        )
//
//        }
//
//}

@Composable
fun RecyclerView(){
    LazyRow(modifier = Modifier.padding(vertical = 4.dp) ){
        items(6){
          //  ListItem(name = "" )
            Column( verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CardWithImage(imagePainter = painterResource(id = R.drawable.vegetable))
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Vegetables",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W500,
                    color = Color.Black,

                )
            }


        }
    }
}
@Composable
fun RecyclerViewForPopular(){
    LazyRow(modifier = Modifier.padding(vertical = 4.dp) ){
        items(6){
            //  ListItem(name = "" )
            Column( verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CardWithPopularImage(imagePainter = painterResource(id = R.drawable.meat_img))
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Meat",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W500,
                    color = Color.Black,

                    )
            }


        }
    }
}

@Composable
fun CardWithPopularImage(imagePainter: Painter) {
    Card(
        modifier = Modifier
            // .width(200.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppSecondaryColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                // .padding(16.dp)
                .height(80.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun CardWithImage(imagePainter: Painter) {
    Card(
        modifier = Modifier
           // .width(200.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppSecondaryColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(50.dp),
        )
    }
}

@Composable
fun CardWithImageDiscount(imagePainter: Painter) {
    Card(
        modifier = Modifier
             //.width(200.dp)
            .padding(8.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .width(300.dp)
                // .padding(16.dp)
                .height(130.dp),
            contentScale = ContentScale.Crop
        )
    }
}







