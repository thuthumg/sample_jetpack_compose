package com.example.jetpackcomposesampleapp

import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import retrofit2.http.GET
import retrofit2.http.POST


//Step 3

interface ApiService {
    @GET("getAllCategories")
    suspend fun getPosts():List<CategoryItemVO>
}