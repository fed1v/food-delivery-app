package com.ivan.fooddelivery.data.repository

import com.ivan.fooddelivery.data.remote.FoodApiService
import com.ivan.fooddelivery.data.remote.toDomainModel
import com.ivan.fooddelivery.domain.models.Category
import com.ivan.fooddelivery.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val api: FoodApiService
) : CategoryRepository {

    override suspend fun getCategories(): List<Category> {
        return api
            .getCategories()
            .body()
            ?.categories
            ?.map { it.toDomainModel() } ?: listOf()
    }

    override suspend fun getCategoryDetails(id: Int): Category? {
        TODO("Not yet implemented")
    }
}