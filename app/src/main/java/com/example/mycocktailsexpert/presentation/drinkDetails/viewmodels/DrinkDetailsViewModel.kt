package com.example.mycocktailsexpert.presentation.drinkDetails.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycocktailsexpert.domain.entities.Drink
import com.example.mycocktailsexpert.domain.repositories.DrinksRepository
import kotlinx.coroutines.launch

class DrinkDetailsViewModel(private val repository: DrinksRepository) : ViewModel() {

    var drink by mutableStateOf<Drink?>(null)

    fun getCocktailById(id: String) {
        viewModelScope.launch {
            val result = repository.getCocktailById(id)
            result.fold(
                onSuccess = {
                    drink = it
                },
                onFailure = {
                    drink = null
                }
            )
        }
    }

    override fun onCleared() {
        println("${this.javaClass.simpleName}:: cleared")
        super.onCleared()
    }
}
