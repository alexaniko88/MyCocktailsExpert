package com.example.mycocktailsexpert.features.drinks.data.repositories

import com.example.mycocktailsexpert.features.drinks.data.datasource.DrinksDatasource
import com.example.mycocktailsexpert.features.drinks.domain.entities.MyDrinks
import com.example.mycocktailsexpert.features.drinks.domain.repositories.DrinksRepository


class DrinksRepositoryImpl(private val datasource: DrinksDatasource) : DrinksRepository {

    override suspend fun searchCocktails(value: String): Result<MyDrinks> {
        return datasource.searchCocktails(value)
    }
}