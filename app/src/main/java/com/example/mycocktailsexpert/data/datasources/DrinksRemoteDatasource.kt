package com.example.mycocktailsexpert.data.datasources

import com.example.mycocktailsexpert.data.dtos.DrinkDTO
import com.example.mycocktailsexpert.data.dtos.MyDrinksDTO
import com.example.mycocktailsexpert.shared.network.RetrofitService


class DrinksRemoteDatasource(private val service: RetrofitService) : DrinksDatasource {

    override suspend fun searchCocktails(value: String): Result<MyDrinksDTO> {
        return try {
            val result = service.searchCocktails(value)
            if (result.drinks.isNullOrEmpty()) {
                Result.success(MyDrinksDTO(emptyList()))
            } else {
                Result.success(result)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCocktailById(id: String): Result<DrinkDTO?> {
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
