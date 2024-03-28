package com.example.mycocktailsexpert.shared.network

import com.example.mycocktailsexpert.data.dtos.MyDrinksDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("search.php?")
    suspend fun searchCocktails(
        @Query("s") filter: String,
    ): MyDrinksDTO

    @GET("lookup.php?")
    suspend fun getCocktailById(
        @Query("i") filter: String,
    ): MyDrinksDTO
}