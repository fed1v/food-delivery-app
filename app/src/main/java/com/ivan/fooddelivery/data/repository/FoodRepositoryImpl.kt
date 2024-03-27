package com.ivan.fooddelivery.data.repository

import com.ivan.fooddelivery.data.database.dao.FoodDao
import com.ivan.fooddelivery.data.remote.FoodApiService
import com.ivan.fooddelivery.data.remote.toDomainModel
import com.ivan.fooddelivery.data.remote.toEntity
import com.ivan.fooddelivery.domain.models.Food
import com.ivan.fooddelivery.domain.repository.FoodRepository
import kotlin.Exception

class FoodRepositoryImpl(
    private val apiService: FoodApiService,
    private val foodDao: FoodDao
) : FoodRepository {

    override suspend fun getFoodList(firstLetter: String): List<Food> {

        try {
            val foodFromApi = apiService
                .getFoodList(firstLetter)
                .body()
                ?.foodList
                ?: listOf()

            foodDao.upsertFoodList(foodFromApi.map { it.toEntity() })

        } catch (_: Exception) {
        }

        return foodDao
            .getAllFood()
            .filter { it.title[0].toString() == firstLetter || it.title[0].lowercase() == firstLetter }
            .map { it.toDomainModel() }
    }

    override suspend fun getFoodDetails(id: Int): Food? {
        TODO("Not yet implemented")
    }
}