package com.ivan.fooddelivery.presentation.models

data class FoodPresentation(
    val id: Int,
    val imageResource: Int,
    val title: String,
    val description: String,
    val price: Double
)