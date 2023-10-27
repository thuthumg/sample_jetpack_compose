package com.example.jetpackcomposesampleapp.util

import com.example.jetpackcomposesampleapp.R
import com.example.jetpackcomposesampleapp.data.vos.EachGroceryItemVO
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import com.example.jetpackcomposesampleapp.data.vos.DiscountCardItemVO
//import com.example.jetpackcomposesampleapp.data.vos.DiscountItemVO
import com.example.jetpackcomposesampleapp.data.vos.DiscountType
import com.example.jetpackcomposesampleapp.data.vos.OrderItemVO
//import com.example.jetpackcomposesampleapp.data.vos.ProductItemVO
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

//val productList: List<ProductItemVO> = listOf(
//    ProductItemVO(1,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
//    ProductItemVO(2,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
//    ProductItemVO(3,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
//    ProductItemVO(4,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
//    ProductItemVO(5,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
//    ProductItemVO(6,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
//    ProductItemVO(7,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
//    ProductItemVO(8,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
//
//    ProductItemVO(9,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
//    ProductItemVO(10,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
//    ProductItemVO(11,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
//    ProductItemVO(12,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
//    ProductItemVO(13,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
//    ProductItemVO(14,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
//    ProductItemVO(15,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
//    ProductItemVO(16,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
//
//
//    ProductItemVO(17,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
//    ProductItemVO(18,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
//    ProductItemVO(19,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
//    ProductItemVO(20,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
//    ProductItemVO(21,"Banana","1.60","$0.20/pc", R.drawable.banana_img,100),
//    ProductItemVO(22,"Mango","4.25","$4.25/kg", R.drawable.mango_img,50),
//    ProductItemVO(23,"Strawberry","1.60","$0.20/pc", R.drawable.strawberry_img,50),
//    ProductItemVO(24,"Orange","17.00","$17.00/kg", R.drawable.orange_img,50),
//)
val productList: List<EachGroceryItemVO> = listOf(
    EachGroceryItemVO(
        itemId = 1,
        itemName = "Banana",
        itemImage = R.drawable.banana_img,
        itemPrice = "1.60",
        itemUnit = "$0.20/pc",
        itemQuantity = 100,
        itemCategoryType = "2"),
    EachGroceryItemVO(
        itemId =2,
        itemName ="Mango",
        itemImage = R.drawable.mango_img,
        itemPrice = "4.25",
        itemUnit= "$4.25/kg",
        itemQuantity = 50,
        itemCategoryType = "2"),
    EachGroceryItemVO(
        itemId = 3,
        itemName = "Strawberry",
        itemImage =  R.drawable.strawberry_img,
        itemPrice = "1.60",
        itemUnit = "$0.20/pc",
        itemQuantity = 50,
        itemCategoryType = "2"),

    EachGroceryItemVO(
        itemId = 4,
        itemName = "Orange",
        itemImage = R.drawable.orange_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "2"),

    EachGroceryItemVO(
        itemId = 5,
        itemName = "Banana",
        itemImage = R.drawable.banana_img,
        itemPrice = "1.60",
        itemUnit = "$0.20/pc",
        itemQuantity = 100,
        itemCategoryType = "2"),

    EachGroceryItemVO(
        itemId = 6,
        itemName = "Mango",
        itemImage = R.drawable.mango_img,
        itemPrice = "4.25",
        itemUnit = "$4.25/kg",
        itemQuantity = 50,
        itemCategoryType = "2"),

    EachGroceryItemVO(
        itemId = 7,
        itemName = "Strawberry",
        itemImage = R.drawable.strawberry_img,
        itemPrice = "1.60",
        itemUnit = "$0.20/pc",
        itemQuantity = 50,
        itemCategoryType = "2"),

    EachGroceryItemVO(
        itemId = 8,
        itemName = "Orange",
        itemImage = R.drawable.orange_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "2"),

    EachGroceryItemVO(
        itemId = 9,
        itemName = "Carrots",
        itemImage = R.drawable.carrots_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "1"),

    EachGroceryItemVO(
        itemId = 10,
        itemName = "Broccoli",
        itemImage = R.drawable.broccoli_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "1"),

    EachGroceryItemVO(
        itemId = 11,
        itemName = "Okra",
        itemImage = R.drawable.okra_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "1"),

    EachGroceryItemVO(
        itemId = 12,
        itemName = "Milk",
        itemImage = R.drawable.milk_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "4"),

    EachGroceryItemVO(
        itemId = 13,
        itemName = "Eggs",
        itemImage = R.drawable.egg_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "4"),

    EachGroceryItemVO(
        itemId = 14,
        itemName = "Fish",
        itemImage = R.drawable.fish_icon,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "5"),
    EachGroceryItemVO(
        itemId = 15,
        itemName = "Octopus",
        itemImage = R.drawable.octopus_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "5"),
    EachGroceryItemVO(
        itemId = 16,
        itemName = "Shrimp",
        itemImage = R.drawable.shrimp_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "5"),

    EachGroceryItemVO(
        itemId = 17,
        itemName = "Crab",
        itemImage = R.drawable.crab_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "5"),

    EachGroceryItemVO(
        itemId = 18,
        itemName = "Beef",
        itemImage = R.drawable.beef_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "3"),

    EachGroceryItemVO(
        itemId = 19,
        itemName = "Chicken",
        itemImage = R.drawable.chicken_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "3"),

    EachGroceryItemVO(
        itemId = 20,
        itemName = "Pork",
        itemImage = R.drawable.pork_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "3"),

    EachGroceryItemVO(
        itemId = 21,
        itemName = "Juice",
        itemImage = R.drawable.juice_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "6"),

    EachGroceryItemVO(
        itemId = 22,
        itemName = "Water",
        itemImage = R.drawable.water_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "6"),
    EachGroceryItemVO(
        itemId = 23,
        itemName = "Grape Wine",
        itemImage = R.drawable.wine_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "6"),

    EachGroceryItemVO(
        itemId = 24,
        itemName = "Strawberry Cake",
        itemImage = R.drawable.strawberry_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "7"),

    EachGroceryItemVO(
        itemId = 25,
        itemName = "Birthday Cake",
        itemImage = R.drawable.birthday_cake_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "7"),

    EachGroceryItemVO(
        itemId = 26,
        itemName = "Wedding Cake",
        itemImage = R.drawable.wedding_cake_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "7"),

    EachGroceryItemVO(
        itemId = 27,
        itemName = "Cheese Cake",
        itemImage = R.drawable.cheese_cake_img,
        itemPrice = "17.00",
        itemUnit = "$17.00/kg",
        itemQuantity = 50,
        itemCategoryType = "7"),

   )


var categoriesList: List<CategoryItemVO> = listOf(
    CategoryItemVO(1,"Vegetables", R.drawable.vegetable_icon),
    CategoryItemVO(2,"Fruits", R.drawable.fruit_icon),
    CategoryItemVO(3,"Meat", R.drawable.meat_icon),
    CategoryItemVO(4,"Milk & Egg", R.drawable.milk_products_icon),
    CategoryItemVO(5,"Fish", R.drawable.fish_icon),
    CategoryItemVO(6,"Drinks", R.drawable.drink_icon),
    CategoryItemVO(7,"Cake", R.drawable.cake_icon))


var discountCardItemList: List<DiscountCardItemVO> = listOf(
    DiscountCardItemVO(
        discountId = 1,
        discountType = DiscountType.PERCENT,
        discountImage = R.drawable.vegetables_discount_img,
        discountPercent = "30 % ",
        discountDescription = "Order any food from app and get the discount",
        discountBgColor = DiscountColorOne,
        discountTitleFontColor = DiscountFontColorOne,
        discountProductItemIdList = arrayListOf(1,2,3,4,5)
    ),
    DiscountCardItemVO(
        discountId = 2,
        discountType = DiscountType.PERCENT,
        discountImage = R.drawable.fruit_discount_img,
        discountPercent = "15 % ",
        discountDescription = "Order any food from app and get the discount",
        discountBgColor = DiscountColorTwo,
        discountTitleFontColor = DiscountFontColorTwo,
        discountProductItemIdList = arrayListOf(6,7,8,9,10)
    ),
    DiscountCardItemVO(
        discountId = 3,
        discountType = DiscountType.PERCENT,
        discountImage =  R.drawable.seafood_discount_img,
        discountPercent = "12 % ",
        discountDescription = "Order any food from app and get the discount",
        discountBgColor = DiscountColorOne,
        discountTitleFontColor = DiscountFontColorOne,
        discountProductItemIdList = arrayListOf(11,12,13)
    )
)

var orderItemList: List<OrderItemVO> = listOf(
    OrderItemVO(
        orderItemId = 1,
        orderItemImage = R.drawable.strawberry_img,
        orderItemName = "Strawberry (1KG)",
        orderItemPrice = "$10.00",
        orderItemStatus = "Pending",
        orderDate = "10 Aug 2023"
    ),
    OrderItemVO(
        orderItemId = 1,
        orderItemImage = R.drawable.strawberry_img,
        orderItemName = "Strawberry (1KG)",
        orderItemPrice = "$10.00",
        orderItemStatus = "Pending",
        orderDate = "10 Aug 2023"
    ),
    OrderItemVO(
        orderItemId = 1,
        orderItemImage = R.drawable.strawberry_img,
        orderItemName = "Strawberry (1KG)",
        orderItemPrice = "$10.00",
        orderItemStatus = "Pending",
        orderDate = "10 Aug 2023"
    ),
    OrderItemVO(
        orderItemId = 1,
        orderItemImage = R.drawable.strawberry_img,
        orderItemName = "Strawberry (1KG)",
        orderItemPrice = "$10.00",
        orderItemStatus = "Pending",
        orderDate = "10 Aug 2023"
    )
)
//var discountItemVOList: List<DiscountItemVO> = listOf(
//
//    DiscountItemVO(R.drawable.banana_img,"-60%","Banana(1KG)",12.00,"1","1"),
//    DiscountItemVO(R.drawable.strawberry_img,"-58%","Strawberry(1KG)",17.00,"1","1"),
//    DiscountItemVO(R.drawable.orange_img,"-55%","Orange-Yellow(1KG)",49.00,"1","1"),
//    DiscountItemVO(R.drawable.watermelon_img,"-30%","Watermelon Slice(1KG)",20.00,"1","1"),
//    DiscountItemVO(R.drawable.banana_img,"-60%","Banana(1KG)",12.00,"1","1"),
//    DiscountItemVO(R.drawable.strawberry_img,"-58%","Strawberry(1KG)",17.00,"1","1"),
//    DiscountItemVO(R.drawable.orange_img,"-55%","Orange-Yellow(1KG)",49.00,"1","1"),
//    DiscountItemVO(R.drawable.watermelon_img,"-30%","Watermelon Slice(1KG)",20.00,"1","1"),
//
//
//)




