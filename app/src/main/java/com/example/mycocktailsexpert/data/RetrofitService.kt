package com.example.mycocktailsexpert.data

import com.example.mycocktailsexpert.data.model.RemoteDrinksResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitService {
    //https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a
    @GET("search.php?")
    suspend fun searchCocktails(
        @Query("f") filter: String,
    ) : RemoteDrinksResult
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }
}