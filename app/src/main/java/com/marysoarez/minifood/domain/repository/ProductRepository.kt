package com.marysoarez.minifood.domain.repository

import com.marysoarez.minifood.domain.model.Product

interface ProductRepository {
    suspend fun getProductsByRestaurant(restaurantId: String): List<Product>
}
