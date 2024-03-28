package com.example.mycocktailsexpert.ui.screens.detail

import android.opengl.Visibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mycocktailsexpert.LocalNavController
import com.example.mycocktailsexpert.R
import com.example.mycocktailsexpert.features.drinks.DrinksViewModel
import com.example.mycocktailsexpert.ui.theme.MyCocktailsExpertTheme
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailDetailsScreen(
    cocktailId: String,
    viewModel: DrinksViewModel = koinViewModel(),
) {
    val navController = LocalNavController.current
    viewModel.getCocktailById(cocktailId)
    MyCocktailsExpertTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (viewModel.drinksResult.drinks.isNullOrEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                    )
                }
            } else {
                val cocktail = viewModel.drinksResult.drinks!!.first()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            navigationIcon = {
                                IconButton(onClick = { navController.navigateUp() }) {
                                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                                }
                            },
                            title = {
                                Text(
                                    cocktail.drink,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    textAlign = TextAlign.Center
                                )
                            },
                        )
                    }
                ) { padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .clip(CircleShape)
                                .width(200.dp),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(cocktail.drinkThumb)
                                .crossfade(true)
                                .placeholder(R.drawable.ic_placeholder)
                                .build(),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        if(!cocktail.ingredient1.isNullOrEmpty()) {
                            Text(
                                cocktail.ingredient1,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center
                            )
                        }
                        if(!cocktail.ingredient2.isNullOrEmpty()) {
                            Text(
                                cocktail.ingredient2,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center
                            )
                        }
                        if(!cocktail.ingredient3.isNullOrEmpty()) {
                            Text(
                                cocktail.ingredient3,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}