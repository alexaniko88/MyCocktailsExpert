package com.example.mycocktailsexpert.data.datasources

import com.example.mycocktailsexpert.data.dtos.DrinkDTO
import com.example.mycocktailsexpert.data.dtos.MyDrinksDTO


interface DrinksDatasource {
    suspend fun searchCocktails(value: String): Result<MyDrinksDTO>
    suspend fun getCocktailById(id: String): Result<DrinkDTO?>
}