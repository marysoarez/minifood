package com.marysoarez.minifood.domain.usecases

import com.marysoarez.minifood.domain.model.Product
import com.marysoarez.minifood.domain.repository.ProductRepository

class GetProductsByRestaurant(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(restaurantId: String): List<Product> {
        return repository.getProductsByRestaurant(restaurantId)
    }
}
