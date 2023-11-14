package com.example.jetpackcomposesampleapp.compose.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun DetailBodyView(innerPadding: PaddingValues, pageState: Boolean, onBackClick: () -> Unit) {

    Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())){

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
            val scrolledY = 0f
            val previousOffset = 0
            LazyColumn(
                Modifier.fillMaxSize(),
                lazyListState,
            ) {
                // Setting the Image as the first
                // item and making it collapsible
                item {

                    DetailScreenHeaderView(
                        scrolledY,
                        lazyListState,
                        previousOffset,
                        onBackClick,
                        pageState)
                }
                items(1) {
                    DetailScreenBodyView()
                }
            }
        }

        DetailScreenBottomView(Modifier.align(Alignment.BottomCenter))


    }
}

@Composable
fun DetailScreenBottomView(modifier: Modifier) {
    Column(modifier = modifier)  {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),

            shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),

            ){
            Row(modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "$14.25", color = Color.Black)
                Button(onClick = {}, modifier =
                Modifier
                    .wrapContentSize(),
                    //.background(AppMainColor),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.filledTonalButtonColors(containerColor = AppMainColor, contentColor = Color.White)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        tint = Color.White,
                        contentDescription ="Cart button icon",
                        modifier = Modifier.size(20.dp))

                    Text(text = "Add to cart", Modifier.padding(start = 10.dp))
                }

            }
        }

        /* Box(
             modifier = Modifier
                 .height(100.dp)
                 .fillMaxWidth()
                 .background(AppBackgroundColor)
         ){



         }*/
    }
}

@Composable
private fun DetailScreenBodyView() {
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
            SimilarProductsView(null,null)


        }

    }
}

@Composable
private fun DetailScreenHeaderView(
    scrolledY: Float,
    lazyListState: LazyListState,
    previousOffset: Int,
    onBackClick: () -> Unit,
    pageState: Boolean
) {
    Box(modifier = Modifier.fillMaxSize())
    {
        Column(Modifier.align(Alignment.Center)) {
            ProductItemImageView(scrolledY, lazyListState, previousOffset)
        }

        Column(Modifier.align(Alignment.TopStart)) {
            BackButtonView(onBackClick)
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
private fun BackButtonView(onBackClick: () -> Unit) {
    IconButton(modifier = Modifier.padding(
        top = dimensionResource(id = R.dimen.margin_medium),
        start = dimensionResource(id = R.dimen.margin_medium)),
        onClick = {onBackClick()}) {
        Icon(
            imageVector = Icons.Filled.ArrowBackIos,
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@Composable
private fun ProductItemImageView(
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