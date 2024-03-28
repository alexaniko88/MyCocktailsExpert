package com.example.mycocktailsexpert.shared.network

import com.example.mycocktailsexpert.features.drinks.domain.entities.MyDrinks
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("search.php?")
    suspend fun searchCocktails(
        @Query("s") filter: String,
    ): MyDrinks

    @GET("lookup.php?")
    suspend fun getCocktailById(
        @Query("i") filter: String,
    ): MyDrinks
}