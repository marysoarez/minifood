package com.marysoarez.minifood.domain.repository

import com.marysoarez.minifood.domain.model.Restaurant

class FakeRestaurantRepository : RestaurantRepository {
    override suspend fun getRestaurants(): List<Restaurant> {
        return listOf(
            Restaurant("1", "Pizza Mania", "https://lirp.cdn-website.com/33406c6e/dms3rep/multi/opt/pizzaria-1920w.jpg"),
            Restaurant("2", "Sushi Go", "https://blog.getinapp.com.br/wp-content/uploads/2023/11/bladimir-garcia-YyVxoeJFBBY-unsplash-1200x600.jpg"),
            Restaurant("3", "Burguer Town", "https://www.kcms.com.br/blog/wp-content/uploads/2022/03/cardapio-de-hamburgueria.jpg")
        )
    }
}