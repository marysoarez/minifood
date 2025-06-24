package com.marysoarez.minifood.presentation.screen.product

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marysoarez.minifood.domain.model.Product
import com.marysoarez.minifood.presentation.viewmodel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ProductListScreen(viewModel: ProductListViewModel, cartViewModel: CartViewModel, navCartViewModel: NavHostController) {
    val products by viewModel.products.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cardápio") },
                actions = {
                    IconButton(onClick = { navCartViewModel.navigate("cart")  }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Carrinho")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(products) { product ->
                ProductCard(
                    product = product,
                    onAddToCart = { cartViewModel.addToCart(product) }
                )
            }

        }
    }
}

@Composable
fun ProductCard(product: Product, onAddToCart: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = product.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "R$ ${product.price}")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onAddToCart) {
                Text("Adicionar ao carrinho")
            }
        }
    }
}

