package com.example.mycocktailsexpert.presentation.drinks.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycocktailsexpert.domain.drinks.entities.MyDrinks
import com.example.mycocktailsexpert.domain.drinks.usecases.SearchDrinksUseCase
import kotlinx.coroutines.launch

class DrinksViewModel(private val useCase: SearchDrinksUseCase) : ViewModel() {

    var searchText by mutableStateOf("")
    var drinksResult by mutableStateOf(MyDrinks(drinks = listOf()))

    fun searchCocktails(value: String) {
        searchText = value
        viewModelScope.launch {
            drinksResult = useCase.execute(value)
        }
    }

    override fun onCleared() {
        println("${this.javaClass.simpleName}:: cleared")
        super.onCleared()
    }
}
