package com.ivan.fooddelivery.data.repository

import com.ivan.fooddelivery.data.remote.FoodApiService
import com.ivan.fooddelivery.data.remote.toDomainModel
import com.ivan.fooddelivery.domain.models.Food
import com.ivan.fooddelivery.domain.repository.FoodRepository

class FoodRepositoryImpl(
    private val apiService: FoodApiService
) : FoodRepository {

    override suspend fun getFoodList(firstLetter: String): List<Food> {
        val response = apiService.getFoodList(firstLetter)

        println("Response: $response")
        println(response.body())

        return response
            .body()
            ?.foodList
            ?.map { it.toDomainModel() }
            ?: listOf<Food>()
    }

    override suspend fun getFoodDetails(id: Int): Food? {
        TODO("Not yet implemented")
    }
}