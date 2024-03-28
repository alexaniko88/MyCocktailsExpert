package com.example.mycocktailsexpert.features.drinkDetails.data.repositories

import com.example.mycocktailsexpert.features.drinkDetails.data.datasource.DrinkDetailsDatasource
import com.example.mycocktailsexpert.features.drinkDetails.domain.repositories.DrinkDetailsRepository
import com.example.mycocktailsexpert.shared.domain.entities.Drink


class DrinkDetailsRepositoryImpl(private val datasource: DrinkDetailsDatasource) :
    DrinkDetailsRepository {

    override suspend fun getCocktailById(id: String): Result<Drink?> {
        return datasource.getCocktailById(id)
    }
}