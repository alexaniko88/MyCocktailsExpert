package com.example.mycocktailsexpert.data

import com.example.mycocktailsexpert.data.datasources.DrinksDatasource
import com.example.mycocktailsexpert.data.dtos.DrinkDTO
import com.example.mycocktailsexpert.data.dtos.MyDrinksDTO
import com.example.mycocktailsexpert.data.repositories.DrinksRepositoryImpl
import com.example.mycocktailsexpert.domain.drinks.entities.Drink
import com.example.mycocktailsexpert.domain.drinks.entities.MyDrinks
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class DrinksRepositoryTest {

    private lateinit var datasource: DrinksDatasource
    private lateinit var repository: DrinksRepositoryImpl

    @Before
    fun setup() {
        datasource = mock(DrinksDatasource::class.java)
        repository = DrinksRepositoryImpl(datasource)
    }

    @Test
    fun `Having drinks repository When searchCocktails is called and datasource returns success Then result is success`() =
        runTest {
            val myDrinks = MyDrinksDTO(listOf())
            `when`(datasource.searchCocktails("Mojito")).thenReturn(Result.success(myDrinks))

            val result = repository.searchCocktails("Mojito")

            assertEquals(result.isSuccess, true)
            assertEquals(result.getOrNull() is MyDrinks, true)
            assertEquals(result.getOrNull()!!.drinks.isEmpty(), true)
        }

    @Test
    fun `Having drinks repository When searchCocktails is called and datasource returns failure Then result is failure`() =
        runTest {
            val exception = Exception()
            `when`(datasource.searchCocktails("Mojito")).thenReturn(Result.failure(exception))

            val result = repository.searchCocktails("Mojito")

            assertEquals(result.isFailure, true)
        }

    @Test
    fun `Having drinks repository When getCocktailById is called and datasource returns success Then result is success`() =
        runTest {
            val drink = DrinkDTO(
                "id",
                "name",
                "tag",
                "category",
                "alcoholic",
                "glass",
                "instructions",
                "image",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
            )

            `when`(datasource.getCocktailById("Mojito")).thenReturn(Result.success(drink))

            val result = repository.getCocktailById("Mojito")

            assertEquals(result.isSuccess, true)
            assertEquals(result.getOrNull() is Drink, true)
            assertEquals(result.getOrNull()!!.idDrink, "id")
        }

    @Test
    fun `Having drinks repository When getCocktailById is called and datasource returns success with null Then result is success with null`() =
        runTest {
            `when`(datasource.getCocktailById("Mojito")).thenReturn(Result.success(null))

            val result = repository.getCocktailById("Mojito")

            assertEquals(result.isSuccess, true)
            assertEquals(result.getOrNull() == null, true)
        }

    @Test
    fun `Having drinks repository When getCocktailById is called and datasource returns failure Then result is failure`() =
        runTest {
            val exception = Exception()
            `when`(datasource.getCocktailById("Mojito")).thenReturn(Result.failure(exception))

            val result = repository.getCocktailById("Mojito")

            assertEquals(result.isFailure, true)
        }
}