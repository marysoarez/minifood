package com.marysoarez.minifood.domain.repository

import com.marysoarez.minifood.domain.model.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants(): List<Restaurant>
}