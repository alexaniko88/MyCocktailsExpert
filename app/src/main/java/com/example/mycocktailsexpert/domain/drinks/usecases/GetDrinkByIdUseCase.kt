package com.example.mycocktailsexpert.domain.drinks.usecases

import com.example.mycocktailsexpert.domain.drinks.entities.Drink


interface GetDrinkByIdUseCase {
    suspend fun execute(id: String): Drink?
}