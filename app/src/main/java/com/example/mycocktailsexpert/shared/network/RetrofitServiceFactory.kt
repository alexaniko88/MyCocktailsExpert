package com.example.mycocktailsexpert.shared.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitServiceFactory {
    private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

    val retrofit: RetrofitService by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Set the desired log level
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // Add logging interceptor
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }
}