package com.example.jetpackcomposesampleapp.compose.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll


import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.ArrowCircleLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Preview
@Composable
fun DetailScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        MainContent()
    }

}

@Composable
private fun MainContent() {

    val state = rememberCollapsingToolbarScaffoldState()

    CollapsingToolbarScaffold(
        modifier = Modifier,
        state = state,
        scrollStrategy = ScrollStrategy.EnterAlways,
        toolbar = {
            val textSize = (18 + (30 - 12) * state.toolbarState.progress).sp

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .pin()
                    .background(color = Color.White)
            )
            ItemDetailImageSection(textSize)
            BackButtonSection()
        }) {
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
                    .verticalScroll(rememberScrollState())
            ) {

                ProductDetailInformationView()
                ProductDetailAndReviewsView()
                SimilarProductsView()


            }

        }
    }

}

@Composable
private fun BackButtonSection() {
    IconButton(onClick = { }) {
        Icon(
            imageVector = Icons.Filled.ArrowCircleLeft,
            contentDescription = null
        )
    }
}

@Composable
private fun ItemDetailImageSection(textSize: TextUnit) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.meat_img),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = if (textSize.value == 18f) 0f else 1f
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



