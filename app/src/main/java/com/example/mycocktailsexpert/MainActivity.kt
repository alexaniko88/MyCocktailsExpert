package com.example.mycocktailsexpert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mycocktailsexpert.data.model.RemoteDrinksResult
import com.example.mycocktailsexpert.features.drinks.DrinksViewModel
import com.example.mycocktailsexpert.ui.theme.MyCocktailsExpertTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCocktailsExpertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DrinksList()
                }
            }
        }
    }
}

@Composable
fun DrinksList() {
    val viewModel: DrinksViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = viewModel.searchText.value,
            onValueChange = {
                viewModel.searchCocktails(it)
            },
            placeholder = { Text("Search") },
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text("TOTAL DRINKS: ${viewModel.drinksResult.value?.drinks?.size ?: 0}")
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            viewModel.drinksResult.value?.drinks?.let {
                items(it) { item ->
                    ListItem(
                        modifier = Modifier
                            .clickable { println(item.instructions) }
                            .fillMaxHeight(),
                        headlineContent = {
                            Text(item.drink)
                        },
                        overlineContent = {
                            Text(item.category)
                        },
                        supportingContent = {
                            Text(item.glass)
                        },
                        leadingContent = {
                            AsyncImage(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .width(60.dp),
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(item.drinkThumb)
                                    .crossfade(true)
                                    .placeholder(R.drawable.ic_placeholder)
                                    .build(),
                                contentDescription = "Drink thumb"
                            )
                        },

                        )
                    Divider(color = Color.Gray)
                }
            }
        }
    }
}