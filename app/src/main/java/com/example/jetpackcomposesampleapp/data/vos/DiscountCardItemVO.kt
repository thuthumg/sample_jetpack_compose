package com.example.jetpackcomposesampleapp.data.vos

import androidx.compose.ui.graphics.Color

data class DiscountCardItemVO(
    val discountId:Int,
    val discountType:DiscountType,
    val discountImage:Int,
    val discountPercent:String,
    val discountDescription:String,
    val discountBgColor:Color,
    val discountTitleFontColor:Color,
    val discountProductItemIdList: ArrayList<Int>
    )


enum class DiscountType {
    BUY_TWO_GET_ONE, PERCENT, TOTAL_AMOUNT_DISCOUNT
}