package com.example.mycocktailsexpert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycocktailsexpert.features.drinks.DrinksViewModel
import com.example.mycocktailsexpert.ui.screens.detail.CocktailDetailsScreen
import com.example.mycocktailsexpert.ui.screens.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    MainScreen(navController)
                }
                composable(
                    route = "detail/{cocktailId}", arguments = listOf(
                        navArgument("cocktailId") {
                            type = NavType.StringType
                        },
                    )
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("cocktailId")
                    requireNotNull(id)
                    CocktailDetailsScreen(cocktailId = id)
                }
            }

        }
    }
}