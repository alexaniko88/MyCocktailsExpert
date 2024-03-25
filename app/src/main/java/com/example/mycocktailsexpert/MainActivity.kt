package com.example.mycocktailsexpert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mycocktailsexpert.data.RetrofitServiceFactory
import com.example.mycocktailsexpert.data.model.RemoteDrinksResult
import com.example.mycocktailsexpert.ui.theme.MyCocktailsExpertTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitServiceFactory.makeRetrofitService()

        lifecycleScope.launch {
            val movies = service.searchCocktails(filter = "c")

            setContent {
                MyCocktailsExpertTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        DrinksList(result = movies)
                    }
                }
            }
        }
    }
}

@Composable
fun DrinksList(result: RemoteDrinksResult) {
    Column {
        Text("TOTAL DRINKS: ${result.drinks.size}")
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(result.drinks) { item ->
                ListItem(
                    modifier = Modifier
                        .clickable { println(item.instructions) }
                        .padding(horizontal = 16.dp),
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
                                .width(100.dp),
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

@Preview(showBackground = true)
@Composable
fun DrinksListPreview() {
    MyCocktailsExpertTheme {
        DrinksList(RemoteDrinksResult(drinks = listOf()))
    }
}