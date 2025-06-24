package com.marysoarez.minifood.domain.repository

import com.marysoarez.minifood.domain.model.Restaurant

class FakeRestaurantRepository : RestaurantRepository {
    override suspend fun getRestaurants(): List<Restaurant> {
        return listOf(
            Restaurant("1", "Pizza Mania", "https://via.placeholder.com/150"),
            Restaurant("2", "Sushi Go", "https://via.placeholder.com/150"),
            Restaurant("3", "Burguer Town", "https://via.placeholder.com/150")
        )
    }
}