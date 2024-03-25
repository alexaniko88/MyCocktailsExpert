package com.example.mycocktailsexpert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.example.mycocktailsexpert.data.RetrofitServiceFactory
import com.example.mycocktailsexpert.data.model.RemoteDrinksResult
import com.example.mycocktailsexpert.ui.theme.MyCocktailsExpertTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitServiceFactory.makeRetrofitService()

        lifecycleScope.launch {
            val movies = service.getAllCocktails()

            setContent {
                MyCocktailsExpertTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        SectionList(result = movies)
                    }
                }
            }
        }
    }
}

@Composable
fun SectionList(result: RemoteDrinksResult) {
    Column {
        Text("TOTAL DRINKS: ${result.drinks.size}")
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(result.drinks) { item ->
                Text(item.instructions)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCocktailsExpertTheme {
        Greeting("Android")
    }
}