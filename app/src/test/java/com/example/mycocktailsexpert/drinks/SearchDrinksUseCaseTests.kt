package com.example.mycocktailsexpert.drinks

import com.example.mycocktailsexpert.domain.drinks.entities.Drink
import com.example.mycocktailsexpert.domain.drinks.entities.MyDrinks
import com.example.mycocktailsexpert.domain.drinks.repositories.DrinksRepository
import com.example.mycocktailsexpert.domain.drinks.usecases.GetDrinkByIdUseCaseImpl
import com.example.mycocktailsexpert.domain.drinks.usecases.SearchDrinksUseCaseImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class SearchDrinksUseCaseTests {

    private val repository: DrinksRepository = mock(DrinksRepository::class.java)
    private val useCase = SearchDrinksUseCaseImpl(repository)

    @Test
    fun `Having use case When execute is called and is success Then expected MyDrinks is returned`() = runTest {
        val searchText = "Mojito"
        val expectedDrinks = MyDrinks(
            listOf(
                Drink(
                    drink = "Mojito",
                    idDrink = "drinkId",
                    ingredient1 = "ingredient1",
                    ingredient2 = "ingredient2",
                    ingredient3 = "ingredient3",
                    alcoholic = "alcoholic",
                    category = "category",
                    drinkThumb = "drinkThumb",
                    glass = "glass",
                    dateModified = "dateModified"
                )
            )
        )
        `when`(repository.searchCocktails(searchText)).thenReturn(Result.success(expectedDrinks))

        val result = useCase.execute(searchText)

        assertEquals(expectedDrinks, result)
    }

    @Test
    fun `Having use case When execute is called and is failure Then MyDrinks with empty list is returned`() = runTest {
        val searchText = "Mojito"
        `when`(repository.searchCocktails(searchText)).thenReturn(Result.failure(Exception()))

        val result = useCase.execute(searchText)

        assertEquals(MyDrinks(drinks = listOf()), result)
    }
}