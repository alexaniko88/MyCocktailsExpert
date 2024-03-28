package com.example.mycocktailsexpert.drinks

import com.example.mycocktailsexpert.domain.drinks.entities.Drink
import com.example.mycocktailsexpert.domain.drinks.repositories.DrinksRepository
import com.example.mycocktailsexpert.domain.drinks.usecases.GetDrinkByIdUseCaseImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class GetDrinkByIdUseCaseTests {

    private val repository: DrinksRepository = mock(DrinksRepository::class.java)
    private val useCase = GetDrinkByIdUseCaseImpl(repository)

    @Test
    fun `Having use case When execute is called and is success Then expected drink is returned`() = runTest {
        val drinkId = "1"
        val expectedDrink = Drink(
            drink = "name",
            idDrink = drinkId,
            ingredient1 = "ingredient1",
            ingredient2 = "ingredient2",
            ingredient3 = "ingredient3",
            alcoholic = "alcoholic",
            category = "category",
            drinkThumb = "drinkThumb",
            glass = "glass",
            dateModified = "dateModified"
        )
        `when`(repository.getCocktailById(drinkId)).thenReturn(Result.success(expectedDrink))

        val result = useCase.execute(drinkId)

        assertEquals(expectedDrink, result)
    }

    @Test
    fun `Having use case When execute is called and is failure Then null drink is returned`() = runTest {
        val drinkId = "1"
        `when`(repository.getCocktailById(drinkId)).thenReturn(Result.failure(Exception()))

        val result = useCase.execute(drinkId)

        assertNull(result)
    }
}