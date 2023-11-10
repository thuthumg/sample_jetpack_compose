package com.example.jetpackcomposesampleapp.data.vos

data class CategoryItemVO(
    val categoryId: Int,
    val categoryName : String,
    val categoryImage: Int?,
    val itemIdList: ArrayList<Int>?
)


/*public class Categories {

    @Id
    private String categoryId;
    private String categoryName;
    private ArrayList<Integer> itemIdList;


}*/