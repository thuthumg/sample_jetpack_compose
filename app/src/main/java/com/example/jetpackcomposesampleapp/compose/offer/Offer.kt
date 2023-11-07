package com.example.jetpackcomposesampleapp.compose.offer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.DiscountCardItemVO
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.example.jetpackcomposesampleapp.util.discountCardItemList
import com.example.jetpackcomposesampleapp.util.fontDimensionResource

@Composable
fun OfferScreen(
    onDiscountItemClick: (DiscountCardItemVO)-> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppMainColor//MaterialTheme.colorScheme.background
    ){
        OfferLayout(onDiscountItemClick)
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OfferLayout(onDiscountItemClick: (DiscountCardItemVO) -> Unit) {
    Scaffold(
     containerColor = AppMainColor,
     topBar = {
         OfferTopAppBar()
     }
    ) { innerPaddingValues->
        OfferContentLayout(innerPaddingValues,onDiscountItemClick)


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OfferContentLayout(innerPaddingValues: PaddingValues,
                               onDiscountItemClick: (DiscountCardItemVO) -> Unit) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),

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
//        onClick = {
//            val intent = Intent(context, DiscountDetailActivity::class.java)
//            context.startActivity(intent)
//        }

        ) {

        OffersListLayout(onDiscountItemClick)


    }
}

@Composable
private fun OffersListLayout(onDiscountItemClick: (DiscountCardItemVO) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(discountCardItemList.size) { position->
            EachDiscountItemLayout(discountCardItemList[position],onDiscountItemClick)
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun OfferTopAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = AppMainColor,
            titleContentColor = Color.White
        ),
        title = {
            Text(
                text = stringResource(R.string.lbl_offer),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = fontDimensionResource(id = R.dimen.text_regular_3x)

            )
        })
}

@Composable
private fun EachDiscountItemLayout(
    discountCardItemVO: DiscountCardItemVO,
    onDiscountItemClick: (DiscountCardItemVO) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.margin_medium))
            .clickable {
                onDiscountItemClick(discountCardItemVO)
            },

        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            topEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomEnd = dimensionResource(id = R.dimen.dimen_card_corner_radius),
            bottomStart = dimensionResource(id = R.dimen.dimen_card_corner_radius)
        ),
        colors = CardDefaults.cardColors(
            containerColor = discountCardItemVO.discountBgColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.dimen_card_elevation),
        )

        ){
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .weight(1f, fill = true)

            )
            {
                DiscountItemImageLayout(discountCardItemVO)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f, fill = true)
            )
            {
                DiscountItemInformationLayout(discountCardItemVO)
            }

        }
    }

}

@Composable
private fun DiscountItemImageLayout(discountCardItemVO: DiscountCardItemVO) {

    Image(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(dimensionResource(id = R.dimen.margin_card_medium_2)),
        painter = painterResource(discountCardItemVO.discountImage),
        contentDescription = "Image",
        contentScale = ContentScale.FillBounds,
    )
}

@Composable
private fun DiscountItemInformationLayout(discountCardItemVO: DiscountCardItemVO) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.margin_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .padding(
                    top = 0.dp,
                    bottom = dimensionResource(id = R.dimen.margin_medium),
                    start = 0.dp,
                    end = 0.dp
                ),
            textAlign = TextAlign.Start,
            text = "${discountCardItemVO.discountPercent} Discount",
            fontWeight = FontWeight.Bold,
            color = discountCardItemVO.discountTitleFontColor,
            fontSize = fontDimensionResource(id = R.dimen.text_regular_3x)
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 0.dp,
                    bottom = dimensionResource(id = R.dimen.margin_medium),
                    start = 0.dp,
                    end = 0.dp
                ),
            textAlign = TextAlign.Start,
            text = "${discountCardItemVO.discountDescription}",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = fontDimensionResource(id = R.dimen.text_regular)
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 0.dp,
                    bottom = dimensionResource(id = R.dimen.margin_medium),
                    start = 0.dp,
                    end = 0.dp
                ),
            textAlign = TextAlign.Start,
            text = "Order Now",
            fontWeight = FontWeight.Bold,
            color = discountCardItemVO.discountTitleFontColor,
            fontSize = fontDimensionResource(id = R.dimen.text_small)
        )
    }
}

@Composable
@Preview
fun OfferScreenPreview() {
    //OfferScreen()
}