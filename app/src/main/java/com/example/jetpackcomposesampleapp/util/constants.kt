package com.example.jetpackcomposesampleapp.util

import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.data.vos.DiscountCardItemVO
import com.example.jetpackcomposesampleapp.data.vos.DiscountItemVO
import com.example.jetpackcomposesampleapp.data.vos.ProductItemVO
import com.example.jetpackcomposesampleapp.ui.theme.DiscountColorOne
import com.example.jetpackcomposesampleapp.ui.theme.DiscountColorTwo
import com.example.jetpackcomposesampleapp.ui.theme.DiscountFontColorOne
import com.example.jetpackcomposesampleapp.ui.theme.DiscountFontColorTwo

var itemList: List<EachGroceryItemVO> =
    listOf(
        EachGroceryItemVO(1,"Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1"),
        EachGroceryItemVO(2,"Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1"),
        EachGroceryItemVO(3,"Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1"),
        EachGroceryItemVO(4,"Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1"),
        EachGroceryItemVO(5,"Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1"),
        EachGroceryItemVO(6,"Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1"),
        EachGroceryItemVO(7,"Strawberry(1KG)", R.drawable.vegetable_icon, "1700", "kg", 10, "1")
        )

val productList: List<ProductItemVO> = listOf(
    ProductItemVO(1,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
    ProductItemVO(2,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
    ProductItemVO(3,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
    ProductItemVO(4,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
    ProductItemVO(5,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
    ProductItemVO(6,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
    ProductItemVO(7,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
    ProductItemVO(8,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),

    ProductItemVO(9,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
    ProductItemVO(10,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
    ProductItemVO(11,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
    ProductItemVO(12,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
    ProductItemVO(13,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
    ProductItemVO(14,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
    ProductItemVO(15,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
    ProductItemVO(16,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),


    ProductItemVO(17,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
    ProductItemVO(18,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
    ProductItemVO(19,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
    ProductItemVO(20,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
    ProductItemVO(21,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
    ProductItemVO(22,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
    ProductItemVO(23,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
    ProductItemVO(24,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),



    // ProductItemVO("Watermelon",1.6,"pc",R.drawable.watermelon_img,20)

)
var categoriesList: List<CategoryItemVO> = listOf(
    CategoryItemVO(1,"Vegetables", R.drawable.vegetable_icon),
    CategoryItemVO(2,"Fruits", R.drawable.fruit_icon),
    CategoryItemVO(3,"Meat", R.drawable.meat_icon),
    CategoryItemVO(4,"Milk & Egg", R.drawable.milk_products_icon),
    CategoryItemVO(5,"Fish", R.drawable.fish_icon),
    CategoryItemVO(6,"Drinks", R.drawable.drink_icon),
    CategoryItemVO(7,"Cake", R.drawable.cake_icon),
    CategoryItemVO(8,"Vegetables1", R.drawable.vegetable_icon),
    CategoryItemVO(9,"Fruits1", R.drawable.fruit_icon),
    CategoryItemVO(10,"Meat1", R.drawable.meat_icon),
    CategoryItemVO(11,"Milk & Egg1", R.drawable.milk_products_icon),
    CategoryItemVO(12,"Fish1", R.drawable.fish_icon),
    CategoryItemVO(13,"Drinks1", R.drawable.drink_icon),
    CategoryItemVO(14,"Cake1", R.drawable.cake_icon),
    CategoryItemVO(15,"Vegetables2", R.drawable.vegetable_icon),
    CategoryItemVO(16,"Fruits2", R.drawable.fruit_icon),
    CategoryItemVO(17,"Meat2", R.drawable.meat_icon),
    CategoryItemVO(18,"Milk & Egg2", R.drawable.milk_products_icon),
    CategoryItemVO(19,"Fish2", R.drawable.fish_icon),
    CategoryItemVO(20,"Drinks2", R.drawable.drink_icon),
    CategoryItemVO(21,"Cake2", R.drawable.cake_icon),

)


var discountCardItemList: List<DiscountCardItemVO> = listOf(
    DiscountCardItemVO( R.drawable.vegetables_discount_img,"30 % ",
        "Order any food from app and get the discount", DiscountColorOne,
        DiscountFontColorOne),
    DiscountCardItemVO( R.drawable.fruit_discount_img,"15 % ",
        "Order any food from app and get the discount", DiscountColorTwo,
        DiscountFontColorTwo),
    DiscountCardItemVO( R.drawable.seafood_discount_img,"12 % ",
        "Order any food from app and get the discount",DiscountColorOne,
        DiscountFontColorOne)

    )


var discountItemVOList: List<DiscountItemVO> = listOf(

    DiscountItemVO(R.drawable.banana_img,"-60%","Banana(1KG)",12.00),
    DiscountItemVO(R.drawable.strawberry_img,"-58%","Strawberry(1KG)",17.00),
    DiscountItemVO(R.drawable.orange_img,"-55%","Orange-Yellow(1KG)",49.00),
    DiscountItemVO(R.drawable.watermelon_img,"-30%","Watermelon Slice(1KG)",20.00),
    DiscountItemVO(R.drawable.banana_img,"-60%","Banana(1KG)",12.00),
    DiscountItemVO(R.drawable.strawberry_img,"-58%","Strawberry(1KG)",17.00),
    DiscountItemVO(R.drawable.orange_img,"-55%","Orange-Yellow(1KG)",49.00),
    DiscountItemVO(R.drawable.watermelon_img,"-30%","Watermelon Slice(1KG)",20.00),


)




