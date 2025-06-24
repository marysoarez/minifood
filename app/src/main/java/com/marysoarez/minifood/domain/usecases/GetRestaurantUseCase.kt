package com.marysoarez.minifood.domain.usecases

import com.marysoarez.minifood.domain.model.Restaurant
import com.marysoarez.minifood.domain.repository.RestaurantRepository

class GetRestaurantsUseCase(
    private val repository: RestaurantRepository
) {
    suspend operator fun invoke(): List<Restaurant> = repository.getRestaurants()
}