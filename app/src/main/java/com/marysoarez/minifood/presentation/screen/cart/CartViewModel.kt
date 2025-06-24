package com.marysoarez.minifood.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.marysoarez.minifood.domain.model.CartItem
import com.marysoarez.minifood.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CartViewModel : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    fun addToCart(product: Product) {
        _cartItems.update { currentList ->
            val existing = currentList.find { it.product.id == product.id }
            if (existing != null) {
                currentList.map {
                    if (it.product.id == product.id) it.copy(quantity = it.quantity + 1) else it
                }
            } else {
                currentList + CartItem(product)
            }
        }
    }

    fun removeFromCart(productId: String) {
        _cartItems.update { currentList ->
            currentList.filterNot { it.product.id == productId }
        }
    }

    fun getTotalPrice(): Double {
        return _cartItems.value.sumOf { it.product.price * it.quantity }
    }

    fun clearCart() {
        _cartItems.value = emptyList()
    }
}
