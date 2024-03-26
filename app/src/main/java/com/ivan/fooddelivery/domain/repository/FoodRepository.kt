package com.ivan.fooddelivery.domain.repository

import com.ivan.fooddelivery.domain.models.Food

interface FoodRepository {

    fun getFoodList(): List<Food>

    fun getFoodDetails(id: Int): Food?
}