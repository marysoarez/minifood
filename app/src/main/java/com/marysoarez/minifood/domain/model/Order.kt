package com.marysoarez.minifood.domain.model

import java.time.LocalDateTime

data class Order(
    val id: String,
    val items: List<CartItem>,
    val total: Double,
    val date: LocalDateTime
)