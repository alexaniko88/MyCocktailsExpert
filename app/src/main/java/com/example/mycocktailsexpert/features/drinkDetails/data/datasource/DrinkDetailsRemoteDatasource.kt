package com.example.mycocktailsexpert.features.drinkDetails.data.datasource

import com.example.mycocktailsexpert.shared.domain.entities.Drink
import com.example.mycocktailsexpert.shared.network.RetrofitService


class DrinkDetailsRemoteDatasource(private val service: RetrofitService) : DrinkDetailsDatasource {

    override suspend fun getCocktailById(id: String): Result<Drink?> {
        return try {
            val result = service.getCocktailById(id)
            if (result.drinks.isNullOrEmpty()) {
                Result.success(null)
            } else {
                Result.success(result.drinks.first())
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}