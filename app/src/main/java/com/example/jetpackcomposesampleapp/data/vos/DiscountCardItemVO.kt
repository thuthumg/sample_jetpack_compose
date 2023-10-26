package com.example.jetpackcomposesampleapp.data.vos

import androidx.compose.ui.graphics.Color

data class DiscountCardItemVO(

    val itemImage:Int,
    val discountPercent:String,
    val discountDescription:String,
    val discountBgColor:Color,
    val discountTitleFontColor:Color
)
