package com.example.jetpackcomposesampleapp.cart

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.DoubleArrow
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.cart.modal.ItemModal
import com.example.jetpackcomposesampleapp.ui.theme.AppBackgroundColor
import com.example.jetpackcomposesampleapp.ui.theme.AppMainColor
import com.google.android.material.button.MaterialButton
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    // on below line we are creating and initializing our array list
    val navController = rememberNavController()
    var itemList: List<ItemModal> = ArrayList<ItemModal>()

// on below line we are adding data to our list.
    itemList =
        itemList + ItemModal("Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1")
    itemList =
        itemList + ItemModal("Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1")
    itemList =
        itemList + ItemModal("Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1")
    itemList =
        itemList + ItemModal("Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1")
    itemList =
        itemList + ItemModal("Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1")


    // on below line we are specifying theme as scaffold.
    Scaffold(
        containerColor = AppMainColor,

        //  modifier = Modifier.fillMaxSize(), // in scaffold we are specifying top bar.
        topBar = {
            // inside top bar we are specifying background color.
            TopAppBar(
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
                        text = "Cart",

                        // on below line we are specifying
                        // modifier to fill max width.
                        modifier = Modifier.fillMaxWidth(),

                        // on below line we are specifying text alignment.
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold

                        // on below line we are specifying color for our text.
                        // color = Color.White
                    )
                }

            )

        }
    ) { innerPadding ->

        selectedItemList(LocalContext.current, innerPadding, itemList)
    }


}

@Composable
fun selectedItemList(current: Context, innerPadding: PaddingValues, itemList: List<ItemModal>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(innerPadding),

        shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppBackgroundColor,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),


        ) {


        Column {
            LazyColumn(modifier = Modifier.padding(8.dp)) {
                items(5) {
                    eachSelectedItemUI(it, current, innerPadding, itemList)
                }
            }
            totalAmountUI()
        }



    }

}

@Composable
fun eachSelectedItemUI(
    position: Int,
    context: Context,
    innerPadding: PaddingValues,
    itemList: List<ItemModal>
) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),

        // shape = RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),


        ) {

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically


        ) {
            Image(

                painter = painterResource(id = itemList[position].itemImage),
                contentDescription = "Javascript",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(5.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center,


                ) {

                Text(
                    modifier = Modifier
                        .padding(8.dp, 0.dp, 0.dp, 0.dp),
                    textAlign = TextAlign.Start,
                    text = "Strawberry(1KG)",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                )

                Text(
                    modifier = Modifier
                        .padding(8.dp, 4.dp, 0.dp, 0.dp),
                    textAlign = TextAlign.Start,
                    text = "$17.00/kg",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray.copy(0.5f),
                    fontSize = 10.sp
                )

                Text(
                    modifier = Modifier
                        .padding(8.dp, 8.dp, 0.dp, 0.dp),
                    textAlign = TextAlign.Start,
                    text = "$17.00",
                    fontWeight = FontWeight.Bold,
                    color = AppMainColor,
                    fontSize = 12.sp
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally


            ) {
                Icon(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .padding(0.dp, 4.dp, 0.dp, 0.dp),
                    tint = Color.Black,
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "Add"
                )
                CustomButton("12")
                Icon(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .padding(0.dp, 4.dp, 0.dp, 0.dp),
                    tint = Color.Black,
                    painter = painterResource(id = R.drawable.minus_icon),
                    contentDescription = "Minus"
                )
            }


        }


    }


}

@Composable
fun CustomButton(txtString:String) {
    Button(
        modifier = Modifier.padding(4.dp),
        onClick = {
            // Action to Perform
        }, colors = ButtonDefaults.buttonColors(
            containerColor = AppMainColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray.copy(0.5f),
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(
            topStartPercent = 20,
            topEndPercent = 20,
            bottomEndPercent = 20,
            bottomStartPercent = 20
        ), // Can add RoundedCorner etc
        //  border = BorderStroke(width = 2.dp, color = Color.Blue),
        content = {
            Text(text = txtString)
            if(txtString == "Checkout")
                Image(imageVector = Icons.Outlined.DoubleArrow, contentDescription = "")
        },
        contentPadding = PaddingValues(
            start = 2.dp,
            top = 2.dp,
            end = 2.dp,
            bottom = 2.dp,
        )

    )
}


@Composable
fun totalAmountUI(){


    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier
                .padding(8.dp, 8.dp, 0.dp, 0.dp),
            textAlign = TextAlign.Start,
            text = "Total: $17.00",
            fontWeight = FontWeight.Bold,
            color = AppMainColor,
            fontSize = 12.sp
        )

        CustomButton("Checkout")
    }


}