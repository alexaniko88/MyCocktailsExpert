package com.example.mycocktailsexpert.domain.drinks.usecases

import com.example.mycocktailsexpert.domain.drinks.entities.Drink
import com.example.mycocktailsexpert.domain.drinks.repositories.DrinksRepository


class GetDrinkByIdUseCaseImpl(private val repository: DrinksRepository) : GetDrinkByIdUseCase {
    override suspend fun execute(id: String): Drink? {
        val result = repository.getCocktailById(id)
        return result.fold(
            onSuccess = {
                it
            },
            onFailure = {
                null
            }
        )
    }
}