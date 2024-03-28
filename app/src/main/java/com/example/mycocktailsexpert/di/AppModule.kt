package com.example.mycocktailsexpert.di

import com.example.mycocktailsexpert.presentation.drinkDetails.viewmodels.DrinkDetailsViewModel
import com.example.mycocktailsexpert.data.datasources.DrinksDatasource
import com.example.mycocktailsexpert.data.datasources.DrinksRemoteDatasource
import com.example.mycocktailsexpert.data.repositories.DrinksRepositoryImpl
import com.example.mycocktailsexpert.domain.repositories.DrinksRepository
import com.example.mycocktailsexpert.presentation.drinks.viewmodels.DrinksViewModel
import com.example.mycocktailsexpert.shared.network.RetrofitService
import com.example.mycocktailsexpert.shared.network.RetrofitServiceFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<RetrofitService> { RetrofitServiceFactory.retrofit }

    single<DrinksDatasource> { DrinksRemoteDatasource(get()) }
    single<DrinksRepository> { DrinksRepositoryImpl(get()) }

    viewModel { DrinksViewModel(get()) }
    viewModel { DrinkDetailsViewModel(get()) }
}