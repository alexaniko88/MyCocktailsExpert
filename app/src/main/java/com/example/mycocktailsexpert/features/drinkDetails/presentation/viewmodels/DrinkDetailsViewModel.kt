package com.example.mycocktailsexpert.features.drinkDetails.presentation.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycocktailsexpert.features.drinkDetails.domain.repositories.DrinkDetailsRepository
import com.example.mycocktailsexpert.shared.domain.entities.Drink
import kotlinx.coroutines.launch

class DrinkDetailsViewModel(private val repository: DrinkDetailsRepository) : ViewModel() {

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
