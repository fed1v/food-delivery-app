package com.ivan.fooddelivery.data.repository

import com.ivan.fooddelivery.R
import com.ivan.fooddelivery.domain.models.Food
import com.ivan.fooddelivery.domain.repository.FoodRepository

class FoodRepositoryImpl : FoodRepository {

    override fun getFoodList(): List<Food> {
        return (1..5).map {
            Food(
                it,
                R.drawable.image_pizza,
                "Pizza$it",
                "Description$it",
                100.0 * it
            )
        }
    }

    override fun getFoodDetails(id: Int): Food? {
        TODO("Not yet implemented")
    }
}