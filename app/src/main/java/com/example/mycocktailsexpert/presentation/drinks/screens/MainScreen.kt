package com.example.mycocktailsexpert.presentation.drinks.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mycocktailsexpert.R
import com.example.mycocktailsexpert.presentation.drinks.viewmodels.DrinksViewModel
import com.example.mycocktailsexpert.shared.ui.composables.CocktailsList
import com.example.mycocktailsexpert.shared.ui.theme.MyCocktailsExpertTheme
import org.koin.androidx.compose.koinViewModel


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(viewModel: DrinksViewModel = koinViewModel()) {
    MyCocktailsExpertTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(title = {
                        Text(stringResource(R.string.my_cocktails))
                    })
                }
            ) { padding ->
                CocktailsList(
                    modifier = Modifier.padding(padding),
                    viewModel = viewModel,
                )
            }
        }
    }
}