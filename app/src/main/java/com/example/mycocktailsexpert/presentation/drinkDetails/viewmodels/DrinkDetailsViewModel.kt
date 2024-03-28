package com.example.mycocktailsexpert.presentation.drinkDetails.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycocktailsexpert.domain.drinks.entities.Drink
import com.example.mycocktailsexpert.domain.drinks.usecases.GetDrinkByIdUseCase
import kotlinx.coroutines.launch

class DrinkDetailsViewModel(private val useCase: GetDrinkByIdUseCase) : ViewModel() {

    var drink by mutableStateOf<Drink?>(null)

    fun getCocktailById(id: String) {
        viewModelScope.launch {
            drink = useCase.execute(id)
        }
    }

    override fun onCleared() {
        println("${this.javaClass.simpleName}:: cleared")
        super.onCleared()
    }
}
