package com.example.mycocktailsexpert.shared.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycocktailsexpert.features.drinkDetails.presentation.screens.CocktailDetailsScreen
import com.example.mycocktailsexpert.features.drinks.presentation.screens.MainScreen

val LocalNavController = compositionLocalOf<NavController> { error("No NavController provided") }

class NavigationRoutes {
    companion object {
        const val MAIN = "main"
        const val DETAIL = "detail/{${NavigationArguments.COCKTAIL_ID}}"
    }
}

class NavigationArguments {
    companion object {
        const val COCKTAIL_ID = "cocktailId"
    }
}

@Composable
fun Navigator() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.MAIN,
            enterTransition = { fadeIn(animationSpec = tween(200)) },
            exitTransition = { fadeOut(animationSpec = tween(200)) },
        ) {
            composable(NavigationRoutes.MAIN) {
                MainScreen()
            }
            composable(
                route = NavigationRoutes.DETAIL,
                arguments = listOf(
                    navArgument(NavigationArguments.COCKTAIL_ID) {
                        type = NavType.StringType
                    },
                ),
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString(NavigationArguments.COCKTAIL_ID)
                requireNotNull(id)
                CocktailDetailsScreen(cocktailId = id)
            }
        }
    }
}