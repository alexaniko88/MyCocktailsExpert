package com.example.mycocktailsexpert.features.drinks.presentation.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycocktailsexpert.features.drinks.domain.entities.MyDrinks
import com.example.mycocktailsexpert.features.drinks.domain.repositories.DrinksRepository
import kotlinx.coroutines.launch

class DrinksViewModel(private val repository: DrinksRepository) : ViewModel() {

    var searchText by mutableStateOf("")
    var drinksResult by mutableStateOf(MyDrinks(drinks = listOf()))

    fun searchCocktails(value: String) {
        searchText = value
        viewModelScope.launch {
            val result = repository.searchCocktails(searchText)
            result.fold(
                onSuccess = {
                    drinksResult = it
                },
                onFailure = {
                    drinksResult = MyDrinks(drinks = listOf())
                }
            )
        }
    }

    override fun onCleared() {
        println("${this.javaClass.simpleName}:: cleared")
        super.onCleared()
    }
}
