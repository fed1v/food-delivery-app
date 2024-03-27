package com.ivan.fooddelivery.domain.repository

import com.ivan.fooddelivery.domain.models.Food

interface FoodRepository {

    suspend fun getFoodList(firstLetter: String): List<Food>

    suspend fun getFoodDetails(id: Int): Food?
}