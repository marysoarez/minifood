package com.marysoarez.minifood.presentation.screen.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marysoarez.minifood.domain.model.Product
import com.marysoarez.minifood.domain.usecases.GetProductsByRestaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val getProductsByRestaurant: GetProductsByRestaurant,
    private val restaurantId: String
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _products.value = getProductsByRestaurant(restaurantId)
        }
    }
}
