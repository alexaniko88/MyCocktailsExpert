package com.example.mycocktailsexpert.features.drinks.data.datasource

import com.example.mycocktailsexpert.features.drinks.domain.entities.MyDrinks
import com.example.mycocktailsexpert.shared.network.RetrofitService


class DrinksRemoteDatasource(private val service: RetrofitService) : DrinksDatasource {

    override suspend fun searchCocktails(value: String): Result<MyDrinks> {
        return try {
            val result = service.searchCocktails(value)
            if (result.drinks.isNullOrEmpty()) {
                Result.success(MyDrinks(emptyList()))
            } else {
                Result.success(result)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}