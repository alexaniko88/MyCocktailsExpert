package com.example.mycocktailsexpert.di

import com.example.mycocktailsexpert.features.drinkDetails.data.datasource.DrinkDetailsDatasource
import com.example.mycocktailsexpert.features.drinkDetails.data.datasource.DrinkDetailsRemoteDatasource
import com.example.mycocktailsexpert.features.drinkDetails.data.repositories.DrinkDetailsRepositoryImpl
import com.example.mycocktailsexpert.features.drinkDetails.domain.repositories.DrinkDetailsRepository
import com.example.mycocktailsexpert.features.drinkDetails.presentation.viewmodels.DrinkDetailsViewModel
import com.example.mycocktailsexpert.features.drinks.data.datasource.DrinksDatasource
import com.example.mycocktailsexpert.features.drinks.data.datasource.DrinksRemoteDatasource
import com.example.mycocktailsexpert.features.drinks.data.repositories.DrinksRepositoryImpl
import com.example.mycocktailsexpert.features.drinks.domain.repositories.DrinksRepository
import com.example.mycocktailsexpert.features.drinks.presentation.viewmodels.DrinksViewModel
import com.example.mycocktailsexpert.shared.network.RetrofitService
import com.example.mycocktailsexpert.shared.network.RetrofitServiceFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<RetrofitService> { RetrofitServiceFactory.retrofit }

    single<DrinksDatasource> { DrinksRemoteDatasource(get()) }
    single<DrinksRepository> { DrinksRepositoryImpl(get()) }

    single<DrinkDetailsDatasource> { DrinkDetailsRemoteDatasource(get()) }
    single<DrinkDetailsRepository> { DrinkDetailsRepositoryImpl(get()) }

    viewModel { DrinksViewModel(get()) }
    viewModel { DrinkDetailsViewModel(get()) }
}