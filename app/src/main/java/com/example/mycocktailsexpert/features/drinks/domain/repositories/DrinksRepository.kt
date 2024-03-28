package com.example.mycocktailsexpert.features.drinks.domain.repositories

import com.example.mycocktailsexpert.features.drinks.domain.entities.MyDrinks


interface DrinksRepository {

    suspend fun searchCocktails(value: String): Result<MyDrinks>

}