package com.example.mycocktailsexpert.shared.ui.composables

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mycocktailsexpert.R
import com.example.mycocktailsexpert.presentation.drinks.viewmodels.DrinksViewModel
import com.example.mycocktailsexpert.shared.navigation.LocalNavController


@Composable
fun CocktailsList(
    modifier: Modifier = Modifier,
    viewModel: DrinksViewModel,
) {
    val navController = LocalNavController.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = viewModel.searchText,
            onValueChange = {
                viewModel.searchCocktails(it)
            },
            placeholder = { Text(stringResource(R.string.search)) },
            singleLine = true,
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(stringResource(R.string.total_drinks, viewModel.drinksResult.drinks.size))
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(viewModel.drinksResult.drinks) { item ->
                ListItem(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("detail/${item.idDrink}")
                        }
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
                            contentDescription = null
                        )
                    },

                    )
                Divider(color = Color.Gray)
            }
        }
    }
}