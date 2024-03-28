package com.example.mycocktailsexpert.domain.drinks.repositories

import com.example.mycocktailsexpert.domain.drinks.entities.Drink
import com.example.mycocktailsexpert.domain.drinks.entities.MyDrinks


interface DrinksRepository {
    suspend fun searchCocktails(value: String): Result<MyDrinks>
    suspend fun getCocktailById(id: String): Result<Drink?>
}