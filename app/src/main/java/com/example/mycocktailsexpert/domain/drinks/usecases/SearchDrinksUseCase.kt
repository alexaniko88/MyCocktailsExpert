package com.example.mycocktailsexpert.domain.drinks.usecases

import com.example.mycocktailsexpert.domain.drinks.entities.MyDrinks


interface SearchDrinksUseCase {
    suspend fun execute(searchText: String): MyDrinks
}