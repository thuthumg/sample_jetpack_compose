package com.example.jetpackcomposesampleapp.compose.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun DetailScreen(pageState:Boolean,onBackClick: ()-> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        MainContent(pageState,onBackClick)
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainContent(pageState: Boolean, onBackClick: () -> Unit) {
    Scaffold(
        // Creating Content
        content = { innerPadding ->

            // Creating a Column Layout
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Creating a Scrollable list of 100 items

                val lazyListState = rememberLazyListState()
                var scrolledY = 0f
                var previousOffset = 0
                LazyColumn(
                    Modifier.fillMaxSize(),
                    lazyListState,
                ) {
                    // Setting the Image as the first
                    // item and making it collapsible
                    item {

                        Box(modifier = Modifier.fillMaxSize())
                        {
                            Column(Modifier.align(Alignment.Center)) {
                                ItemImageSection(scrolledY, lazyListState, previousOffset)
                            }

                            Column(Modifier.align(Alignment.TopStart)) {
                                BackButtonSection(onBackClick)
                            }

                            Column(
                                Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(
                                        top = dimensionResource(id = R.dimen.margin_medium_2),
                                        end = dimensionResource(id = R.dimen.margin_medium_2),
                                    )
                            ) {
                                if (pageState)
                                    DetailPageDiscountPercentView()
                            }
                        }
                    }
                    items(1) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(3.dp),

                            shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = AppBackgroundColor,
                            ),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            ),

                            ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                // .verticalScroll(rememberScrollState())
                            ) {

                                ProductDetailInformationView()
                                ProductDetailAndReviewsView()
                                SimilarProductsView()


                            }

                        }
                    }
                }
            }
        }
    )
}
@Composable
private fun DetailPageDiscountPercentView() {
    Card(
        modifier = Modifier
            .wrapContentSize(),

        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.margin_medium),
            topEnd = dimensionResource(id = R.dimen.margin_medium),
            bottomEnd = dimensionResource(id = R.dimen.margin_medium),
            bottomStart = dimensionResource(id = R.dimen.margin_medium),
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Red,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        ),


        ) {
        Text(
            modifier = Modifier
                .padding(
                    top = dimensionResource(id = R.dimen.margin_card_medium),
                    bottom = dimensionResource(id = R.dimen.margin_card_medium),
                    start = dimensionResource(id = R.dimen.margin_medium_2),
                    end = dimensionResource(id = R.dimen.margin_medium_2),
                ),
            textAlign = TextAlign.Start,
            text = "-55%",
            fontWeight = FontWeight.W400,
            color = Color.White,
            fontSize = fontDimensionResource(id = R.dimen.text_small)
        )
    }
}

@Composable
private fun BackButtonSection(onBackClick: () -> Unit) {
    IconButton(modifier = Modifier.padding(
            top = dimensionResource(id = R.dimen.margin_medium),
        start = dimensionResource(id = R.dimen.margin_medium)), onClick = {
            onBackClick()
    }) {
        Icon(
            imageVector = Icons.Filled.ArrowBackIos,
            contentDescription = null,
            tint = Color.Black
        )
    }
}




@Composable
private fun ItemImageSection(
    scrolledY: Float,
    lazyListState: LazyListState,
    previousOffset: Int
) {
    var scrolledY1 = scrolledY
    var previousOffset1 = previousOffset
    Image(
        painter = painterResource(id = R.drawable.meat_icon),
        contentDescription = null,
        //  contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .graphicsLayer {
                scrolledY1 += lazyListState.firstVisibleItemScrollOffset - previousOffset1
                translationY = scrolledY1 * 0.5f
                previousOffset1 = lazyListState.firstVisibleItemScrollOffset
            }
            .height(240.dp)
        // .fillMaxSize()
    )
}

//@Composable // custom manually rating bar code
//fun RatingBar(
//    modifier: Modifier = Modifier,
//    rating: Int
//){
//    var ratingState by remember{
//        mutableStateOf(rating)
//    }
//
//    var selected by remember{
//        mutableStateOf(false)
//    }
//
//    val size by animateDpAsState(
//        targetValue = if(selected) 72.dp else 64.dp,
//    spring(Spring.DampingRatioLowBouncy), label = ""
//    )
//
//    Row (
//        modifier = Modifier.fillMaxSize(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
//    ){
//        for (i in 1..5){
//            Icon(
//                painter = painterResource(id = R.drawable.ic_start),
//                contentDescription = "star",
//                modifier = modifier
//                    .width(size)
//                    .height(size)
//                    .pointerInteropFilter {
//                        when (it.action) {
//                            MotionEvent.ACTION_DOWN -> {
//                                selected = true
//                                ratingState = i
//                            }
//
//                            MotionEvent.ACTION_UP -> {
//                                selected = false
//                            }
//                        }
//                        true
//                    }
//                    .clickable {
//                        ratingState = i
//                    },
//                tint = if(i <= ratingState) Color(0xFFFFD700) else Color(0xFFA2ADB1)
//            )
//        }
//    }
//}


//@Composable
//private fun MainContent() {
//
//    val state = rememberCollapsingToolbarScaffoldState()
//
//    CollapsingToolbarScaffold(
//        modifier = Modifier,
//        state = state,
//        scrollStrategy = ScrollStrategy.EnterAlways,
//        toolbar = {
//            val textSize = (18 + (30 - 12) * state.toolbarState.progress).sp
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(20.dp)
//                    .pin()
//                    .background(color = Color.White)
//            )
//            ItemDetailImageSection(textSize)
//            BackButtonSection()
//            DetailPageDiscountPercentView()
//        }
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .padding(3.dp),
//
//            shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
//            colors = CardDefaults.cardColors(
//                containerColor = AppBackgroundColor,
//            ),
//            elevation = CardDefaults.cardElevation(
//                defaultElevation = 10.dp
//            ),
//
//            ) {
//
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .verticalScroll(rememberScrollState())
//            ) {
//
//                ProductDetailInformationView()
//                ProductDetailAndReviewsView()
//                SimilarProductsView()
//
//
//            }
//
//        }
//    }
//
//}

//@Composable
//private fun ItemDetailImageSection(textSize: TextUnit) {
//
//    Image(
//        modifier = Modifier.fillMaxSize(),
//        painter = painterResource(id = R.drawable.meat_img),
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        alpha = if (textSize.value == 18f) 0f else 1f
//    )
//}



