package com.marysoarez.minifood.presentation.screen.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marysoarez.minifood.presentation.viewmodel.CartViewModel
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CartScreen(cartViewModel: CartViewModel) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Carrinho") })
        },
        bottomBar = {
            if (cartItems.isNotEmpty()) {
                BottomAppBar(
                    modifier = Modifier.height(80.dp),
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)) {
                        Text("Total: R$ ${String.format("%.2f", cartViewModel.getTotalPrice())}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { cartViewModel.clearCart() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Finalizar Pedido")
                        }
                    }
                }
            }
        }
    ) { padding ->
        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("Seu carrinho está vazio.")
            }
        } else {
            LazyColumn(contentPadding = padding) {
                items(cartItems) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(item.product.name, style = MaterialTheme.typography.titleMedium)
                            Text("Preço unitário: R$ ${item.product.price}")
                            Text("Quantidade: ${item.quantity}")
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(onClick = {
                                cartViewModel.removeFromCart(item.product.id)
                            }) {
                                Text("Remover")
                            }
                        }
                    }
                }
            }
        }
    }
}
