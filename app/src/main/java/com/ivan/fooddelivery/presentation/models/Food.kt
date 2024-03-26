package com.ivan.fooddelivery.presentation.models

data class Food(
    val id: Int,
    val imageResource: Int,
    val title: String,
    val description: String,
    val price: Double
)