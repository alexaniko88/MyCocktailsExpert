package com.example.mycocktailsexpert.features.drinkDetails.data.datasource

import com.example.mycocktailsexpert.shared.domain.entities.Drink


interface DrinkDetailsDatasource {
    suspend fun getCocktailById(id: String): Result<Drink?>
}