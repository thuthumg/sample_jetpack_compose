package com.example.jetpackcomposesampleapp.data.vos

import androidx.compose.ui.graphics.Color

data class DiscountItemVO(
    val itemImage:Int,
    val discountPercent:String,
    val discountItemName:String,
    val itemOriginalPrice: Double
)
