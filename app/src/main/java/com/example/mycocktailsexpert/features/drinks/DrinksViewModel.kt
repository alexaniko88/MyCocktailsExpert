package com.example.mycocktailsexpert.features.drinks


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycocktailsexpert.data.RetrofitServiceFactory
import com.example.mycocktailsexpert.data.model.RemoteDrinksResult
import kotlinx.coroutines.launch

class DrinksViewModel : ViewModel() {

    private val service = RetrofitServiceFactory.retrofit

    var searchText: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue())
    val drinksResult: MutableState<RemoteDrinksResult> = mutableStateOf(RemoteDrinksResult(drinks = listOf()))

    fun searchCocktails(value: TextFieldValue) {
        searchText.value = value
        viewModelScope.launch {
            val result = try {
                service.searchCocktails(searchText.value.text)
            } catch (e: Exception) {
                RemoteDrinksResult(drinks = listOf())
            }
            drinksResult.value = if (result.drinks == null) {
                RemoteDrinksResult(drinks = listOf())
            } else {
                result
            }
        }
    }
}
