package com.example.mycocktailsexpert.data

import com.example.mycocktailsexpert.data.dtos.DrinkDTO
import com.example.mycocktailsexpert.data.dtos.MyDrinksDTO
import com.example.mycocktailsexpert.domain.entities.Drink
import com.example.mycocktailsexpert.domain.entities.MyDrinks


fun MyDrinksDTO.toMyDrinks() = MyDrinks(
    drinks = drinks?.map { it.toDrink() } ?: listOf()
)

fun DrinkDTO.toDrink() = Drink(
    idDrink = idDrink,
    alcoholic = alcoholic ?: "",
    category = category ?: "",
    drink = drink ?: "",
    drinkThumb = drinkThumb ?: "",
    glass = glass ?: "",
    ingredient1 = ingredient1 ?: "",
    ingredient2 = ingredient2 ?: "",
    ingredient3 = ingredient3 ?: "",
    dateModified = dateModified ?: "",
)