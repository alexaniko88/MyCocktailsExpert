package com.example.mycocktailsexpert.domain.repositories

import com.example.mycocktailsexpert.domain.entities.Drink
import com.example.mycocktailsexpert.domain.entities.MyDrinks


interface DrinksRepository {
    suspend fun searchCocktails(value: String): Result<MyDrinks>
    suspend fun getCocktailById(id: String): Result<Drink?>
}