package com.example.jetpackcomposesampleapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposesampleapp.data.vos.CategoryItemVO
import kotlinx.coroutines.launch


//step 5
class MainViewModel : ViewModel() {
    private val apiService = RetrofitInstance.api
    val posts: MutableState<List<CategoryItemVO>> = mutableStateOf(emptyList())
    fun getPosts() {
        viewModelScope.launch {
            try {
                val response = apiService.getPosts()
                if (response.isNotEmpty()) {
                    posts.value = response
                }
            } catch (e: Exception) {
                // Handle errors here
            }
        }
    }
}