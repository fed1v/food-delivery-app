package com.ivan.fooddelivery.domain.models

data class Food(
    val id: Int,
    val imageLink: String?,
    val title: String,
    val ingredients: List<String>,
    val price: Double
)