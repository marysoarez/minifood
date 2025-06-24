package com.marysoarez.minifood.presentation.screen.home
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.marysoarez.minifood.domain.model.Restaurant
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onRestaurantClick: (String) -> Unit
) {
    val restaurants by viewModel.restaurants.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("MiniFood") }) }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(restaurants) { restaurant ->
                RestaurantCard(restaurant, onClick = { onRestaurantClick(restaurant.id) })
            }
        }
    }
}


@Composable
fun RestaurantCard(restaurant: Restaurant, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Row {
            Image(
                painter = rememberImagePainter(restaurant.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = restaurant.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
