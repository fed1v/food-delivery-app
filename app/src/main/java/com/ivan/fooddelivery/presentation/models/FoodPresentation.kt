package com.ivan.fooddelivery.presentation.models

data class FoodPresentation(
    val id: Int,
    val imageLink: String?,
    val title: String,
    val ingredients: String,
    val price: String
)