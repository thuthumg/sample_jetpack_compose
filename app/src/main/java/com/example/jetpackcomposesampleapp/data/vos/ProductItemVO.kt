package com.example.jetpackcomposesampleapp.data.vos

import android.media.Image

data class ProductItemVO(
    val productName:String,
    val productPrice:String,
    val productUnit:String,
    val productImage:Int,
    val productQuantity:Int
)