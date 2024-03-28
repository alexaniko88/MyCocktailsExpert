package com.example.mycocktailsexpert.di

import com.example.mycocktailsexpert.presentation.drinkDetails.viewmodels.DrinkDetailsViewModel
import com.example.mycocktailsexpert.data.datasources.DrinksDatasource
import com.example.mycocktailsexpert.data.datasources.DrinksRemoteDatasource
import com.example.mycocktailsexpert.data.repositories.DrinksRepositoryImpl
import com.example.mycocktailsexpert.domain.drinks.repositories.DrinksRepository
import com.example.mycocktailsexpert.domain.drinks.usecases.GetDrinkByIdUseCase
import com.example.mycocktailsexpert.domain.drinks.usecases.GetDrinkByIdUseCaseImpl
import com.example.mycocktailsexpert.domain.drinks.usecases.SearchDrinksUseCase
import com.example.mycocktailsexpert.domain.drinks.usecases.SearchDrinksUseCaseImpl
import com.example.mycocktailsexpert.presentation.drinks.viewmodels.DrinksViewModel
import com.example.mycocktailsexpert.shared.network.RetrofitService
import com.example.mycocktailsexpert.shared.network.RetrofitServiceFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single<RetrofitService> { RetrofitServiceFactory.retrofit }

    /**
     * DataSources
     */
    single<DrinksDatasource> { DrinksRemoteDatasource(get()) }

    /**
     * Repositories
     */
    single<DrinksRepository> { DrinksRepositoryImpl(get()) }

    /**
     * UseCases
     */
    single<SearchDrinksUseCase> { SearchDrinksUseCaseImpl(get()) }
    single<GetDrinkByIdUseCase> { GetDrinkByIdUseCaseImpl(get()) }

    /**
     * ViewModels
     */
    viewModel { DrinksViewModel(get()) }
    viewModel { DrinkDetailsViewModel(get()) }
}