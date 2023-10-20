package com.example.jetpackcomposesampleapp.compose.detail

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.fontDimensionResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle
import kotlinx.coroutines.launch


@Preview
@Composable
fun ProductDetailAndReviewsView(){
    DetailAndReviewsSection()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun DetailAndReviewsSection() {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.margin_card_medium_2)),

        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimen_card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.dimen_card_elevation)
        ),

        ) {
        TabLayout()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalPagerApi
@Composable
private fun TabLayout() {
    val pagerState = rememberPagerState(pageCount = {
        2
    })
    Column(modifier = Modifier.background(Color.White)) {

        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Tabs(pagerState: PagerState) {

    val list = listOf(
        "Details",
        "Reviews"
    )

    val scope = rememberCoroutineScope()
    TabRow(
        modifier = Modifier.fillMaxSize(),
        divider = {
            Modifier.background(Color.White)
        },
        selectedTabIndex = pagerState.currentPage,
        containerColor = Color.White,
        contentColor = TabRowDefaults.contentColor,
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.dimen_indicator_width))
                    .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                    .height(dimensionResource(id = R.dimen.dimen_indicator_height))
                    // .clip(RoundedCornerShape(20.dp)) // clip modifier not working
                    .padding(90.dp, 5.dp, 90.dp, 0.dp)//horizontal = 90.dp
                    .background(
                        color = AppMainColor,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimen_tab_indicator_size))
                    )
                // .background(color = AppMainColor)
            )

        }

    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                text = {
                    Text(
                        list[index],
                        color = if (pagerState.currentPage == index) Color.Black else Color.Gray.copy(
                            0.5f
                        ),
                        fontSize = fontDimensionResource(id = R.dimen.text_regular_2x),
                        fontWeight = FontWeight.Bold,
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TabsContent(pagerState: PagerState) {
    HorizontalPager(
        modifier = Modifier.background(Color.White),
        state = pagerState
    ) {
            page ->
        when (page) {
            0 -> DetailTabContentScreen()
            1 -> ReviewsTabContentScreen()
        }
    }
}

@Composable
private fun DetailTabContentScreen() {
    val bullet = "\t\t \u2022"
    val messages = listOf(
        "Hey This is first paragraph",
        "Hey this is my second paragraph. Any this is 2nd line.",
        "Hey this is 3rd paragraph."
    )
    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))

    ProductDescriptionSection(messages, paragraphStyle, bullet)


}

@Composable
private fun ProductDescriptionSection(
    messages: List<String>,
    paragraphStyle: ParagraphStyle,
    bullet: String
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimensionResource(R.dimen.margin_card_medium_2)),

        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimen_card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = AppMainColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.margin_card_medium_2))
        ) {
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                        " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                        "when an unknown printer took a galley of type and scrambled it to make " +
                        "a type specimen book. " +
                        "It has survived not only five centuries, but also the leap into electronic" +
                        " typesetting, remaining essentially unchanged. It was popularised " +
                        "in the 1960s with the release of Letraset sheets containing " +
                        "Lorem Ipsum passages, and more recently with desktop publishing software l" +
                        "ike Aldus PageMaker including versions of Lorem Ipsum.",
                modifier = Modifier.padding(dimensionResource(R.dimen.margin_card_medium_2)),
                color = Color.White
            )

            Text(
                buildAnnotatedString {
                    messages.forEach {
                        withStyle(style = paragraphStyle) {
                            /*append(
                                AnnotatedString("AnnotatedString", spanStyle = SpanStyle(Color.Red))
                            )*/
                            append(AnnotatedString(bullet, spanStyle = SpanStyle(Color.White)))
                            append("\t\t")
                            append(it)
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun ReviewsTabContentScreen() {
    ProductItemReviewListSection()
}

@Composable
private fun ProductItemReviewListSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(R.dimen.margin_card_medium_2)),

        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimen_card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = AppMainColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation)
        ),
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.margin_card_medium_2)),
        ) {
            repeat(5) { index ->
                ReviewEachItemSection()
            }
        }
    }
}

@Composable
private fun ReviewEachItemSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        ProfileAndRatingSection()
        ReviewDescriptionSection()
    }

}

@Composable
private fun ReviewDescriptionSection() {
    Text(
        text = "The dial on this timepiece is extremely unique, as it is a concentric circular pattern that is covered by sturdy sapphire glass",
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        color = Color.White,
        fontSize = 12.sp,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start,

        )
}

@Composable
private fun ProfileAndRatingSection() {
    Row {
        ProfileImageSection()
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            ProfileNameSection()
            RatingAndDateSection()
        }
    }
}

@Composable
private fun ProfileNameSection() {
    Text(
        text = "Victor Flexin",
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        color = Color.White,
        fontSize = 14.sp,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start,

        )
}

@Composable
private fun ProfileImageSection() {
    Image(
        painter = painterResource(R.drawable.sample_profile),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)                       // clip to the circle shape
            .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
    )
}


@Composable
private fun RatingAndDateSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {

        var rating: Float by remember { mutableStateOf(3.2f) }

        RatingBar(
            value = rating,
            numOfStars = 5,
            size = 20.dp,
            spaceBetween = 5.dp,
            style = RatingBarStyle.Fill(),
            onValueChange = {
                rating = it
            },
            onRatingChanged = {
                Log.d("TAG", "onRatingChanged: $it")
            }
        )
        Text(
            text = "23 Sep, 2023",
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Center,

            )

    }

}