package com.marysoarez.minifood.domain.repository

import com.marysoarez.minifood.domain.model.Product

class FakeProductRepository : ProductRepository {
    override suspend fun getProductsByRestaurant(restaurantId: String): List<Product> {
        return listOf(
            Product("1", "Pizza Margherita", "Molho, muçarela e manjericão", 35.0, "https://via.placeholder.com/150", "1"),
            Product("2", "Pizza Calabresa", "Calabresa, cebola e azeitona", 38.0, "https://via.placeholder.com/150", "1"),
            Product("3", "Temaki Salmão", "Temaki com salmão fresco", 22.0, "https://via.placeholder.com/150", "2")
        ).filter { it.restaurantId == restaurantId }
    }
}
