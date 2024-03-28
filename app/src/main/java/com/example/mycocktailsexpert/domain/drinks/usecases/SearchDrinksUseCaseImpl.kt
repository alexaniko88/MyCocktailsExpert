package com.example.mycocktailsexpert.domain.drinks.usecases

import com.example.mycocktailsexpert.domain.drinks.entities.MyDrinks
import com.example.mycocktailsexpert.domain.drinks.repositories.DrinksRepository


class SearchDrinksUseCaseImpl(private val repository: DrinksRepository) : SearchDrinksUseCase {
    override suspend fun execute(searchText: String): MyDrinks {
        val result = repository.searchCocktails(searchText)
        return result.fold(
            onSuccess = {
                it
            },
            onFailure = {
                MyDrinks(drinks = listOf())
            }
        )
    }
}