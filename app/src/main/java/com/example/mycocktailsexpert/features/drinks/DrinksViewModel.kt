package com.example.mycocktailsexpert.features.drinks


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycocktailsexpert.data.RetrofitServiceFactory
import com.example.mycocktailsexpert.data.model.RemoteDrinksResult
import kotlinx.coroutines.launch

class DrinksViewModel : ViewModel() {

    private val service = RetrofitServiceFactory.retrofit

    var searchText by mutableStateOf("")
    var drinksResult by mutableStateOf(RemoteDrinksResult(drinks = listOf()))

    fun searchCocktails(value: String) {
        searchText = value
        viewModelScope.launch {
            val result = try {
                service.searchCocktails(searchText)
            } catch (e: Exception) {
                RemoteDrinksResult(drinks = listOf())
            }
            drinksResult = if (result.drinks == null) {
                RemoteDrinksResult(drinks = listOf())
            } else {
                result
            }
        }
    }

    fun getCocktailById(id: String) {
        viewModelScope.launch {
            val result = try {
                service.getCocktailById(id)
            } catch (e: Exception) {
                RemoteDrinksResult(drinks = listOf())
            }
            drinksResult = if (result.drinks == null) {
                RemoteDrinksResult(drinks = listOf())
            } else {
                result
            }
        }
    }
}
