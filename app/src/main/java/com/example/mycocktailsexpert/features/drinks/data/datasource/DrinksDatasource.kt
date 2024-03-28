package com.example.mycocktailsexpert.features.drinks.data.datasource

import com.example.mycocktailsexpert.features.drinks.domain.entities.MyDrinks


interface DrinksDatasource {
    suspend fun searchCocktails(value: String): Result<MyDrinks>
}