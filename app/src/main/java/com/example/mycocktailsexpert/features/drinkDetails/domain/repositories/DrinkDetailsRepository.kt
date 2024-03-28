package com.example.mycocktailsexpert.features.drinkDetails.domain.repositories

import com.example.mycocktailsexpert.shared.domain.entities.Drink

interface DrinkDetailsRepository {
    suspend fun getCocktailById(id: String): Result<Drink?>
}