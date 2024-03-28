package com.example.mycocktailsexpert.di

import com.example.mycocktailsexpert.data.RetrofitService
import com.example.mycocktailsexpert.data.RetrofitServiceFactory
import com.example.mycocktailsexpert.features.drinks.DrinksViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {
    single<RetrofitService> { RetrofitServiceFactory.retrofit }
    viewModelOf(::DrinksViewModel)
}