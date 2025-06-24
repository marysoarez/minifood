package com.marysoarez.minifood.domain.repository

import com.marysoarez.minifood.domain.model.Product

class FakeProductRepository : ProductRepository {
    override suspend fun getProductsByRestaurant(restaurantId: String): List<Product> {
        return listOf(
            Product("1", "Pizza Margherita", "Molho, muçarela e manjericão", 35.0, "https://cdn.casaeculinaria.com/wp-content/uploads/2023/11/21140713/Pizza-marguerita.webp", "1"),
            Product("2", "Pizza Calabresa", "Calabresa, cebola e azeitona", 38.0, "https://anamariareceitas.com.br/wp-content/uploads/2024/08/pizza-de-calabresa_1723632793345.jpg", "1"),
            Product("3", "Temaki Salmão", "Temaki com salmão fresco", 22.0, "https://static.itdg.com.br/images/1200-675/774375583e3775acf3328a7c7a0a0470/303152-original.jpg", "2")
        ).filter { it.restaurantId == restaurantId }
    }
}
