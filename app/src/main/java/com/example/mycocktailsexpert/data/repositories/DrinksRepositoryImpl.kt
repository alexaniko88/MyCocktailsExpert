package com.example.mycocktailsexpert.data.repositories

import com.example.mycocktailsexpert.data.datasources.DrinksDatasource
import com.example.mycocktailsexpert.data.toDrink
import com.example.mycocktailsexpert.data.toMyDrinks
import com.example.mycocktailsexpert.domain.drinks.entities.Drink
import com.example.mycocktailsexpert.domain.drinks.entities.MyDrinks
import com.example.mycocktailsexpert.domain.drinks.repositories.DrinksRepository


class DrinksRepositoryImpl(private val datasource: DrinksDatasource) : DrinksRepository {

    override suspend fun searchCocktails(value: String): Result<MyDrinks> {
        val result = datasource.searchCocktails(value)
        return result.fold(
            onSuccess = {
                Result.success(it.toMyDrinks())
            },
            onFailure = {
                Result.failure(it)
            }
        )
    }

    override suspend fun getCocktailById(id: String): Result<Drink?> {
        val result = datasource.getCocktailById(id)
        return result.fold(
            onSuccess = {
                Result.success(it?.toDrink())
            },
            onFailure = {
                Result.failure(it)
            }
        )
    }
}