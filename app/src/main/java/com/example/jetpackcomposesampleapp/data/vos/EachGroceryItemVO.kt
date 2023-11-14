package com.example.jetpackcomposesampleapp.data.vos

data class EachGroceryItemVO(
    val itemId: Int,
    val itemName : String,
    val itemImage: Int,
    val itemPrice: String,
    val itemUnit: String,
    val itemQuantity: Int,
    val itemCategoryType:String,
    var selectedItemQuantity:Int = 0
)
