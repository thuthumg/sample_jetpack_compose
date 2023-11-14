package com.example.jetpackcomposesampleapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//Step 4
object RetrofitInstance {

    private
    const val BASE_URL = "http://206.189.153.3:8080/grocery-0.0.1/" // //
    val api: ApiService by lazy {

        val httpLoggingInterceptor1 = HttpLoggingInterceptor()
        httpLoggingInterceptor1.level = HttpLoggingInterceptor.Level.BODY

        val mOkHttpClientForTokenApiCall = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor1)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClientForTokenApiCall)
            .build()
        retrofit.create(ApiService::class.java)
    }
}
