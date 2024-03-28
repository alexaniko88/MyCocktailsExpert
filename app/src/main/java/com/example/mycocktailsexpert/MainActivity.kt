package com.example.mycocktailsexpert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycocktailsexpert.ui.screens.detail.CocktailDetailsScreen
import com.example.mycocktailsexpert.ui.screens.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CompositionLocalProvider(LocalNavController provides navController) {
                NavHost(
                    navController = navController,
                    startDestination = "main",
                    enterTransition = { fadeIn(animationSpec = tween(200)) },
                    exitTransition = { fadeOut(animationSpec = tween(200)) },
                ) {
                    composable("main") {
                        MainScreen()
                    }
                    composable(
                        route = "detail/{cocktailId}",
                        arguments = listOf(
                            navArgument("cocktailId") {
                                type = NavType.StringType
                            },
                        ),
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("cocktailId")
                        requireNotNull(id)
                        CocktailDetailsScreen(cocktailId = id)
                    }
                }
            }
        }
    }
}