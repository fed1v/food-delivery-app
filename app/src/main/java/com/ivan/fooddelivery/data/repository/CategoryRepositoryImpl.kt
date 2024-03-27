package com.ivan.fooddelivery.data.repository

import com.ivan.fooddelivery.data.database.dao.CategoryDao
import com.ivan.fooddelivery.data.remote.FoodApiService
import com.ivan.fooddelivery.data.remote.toDomainModel
import com.ivan.fooddelivery.data.remote.toEntity
import com.ivan.fooddelivery.domain.models.Category
import com.ivan.fooddelivery.domain.repository.CategoryRepository
import java.lang.Exception

class CategoryRepositoryImpl(
    private val api: FoodApiService,
    private val categoryDao: CategoryDao
) : CategoryRepository {

    override suspend fun getCategories(): List<Category> {

        try {
            val categoriesFromApi = api
                .getCategories()
                .body()
                ?.categories ?: listOf()

            categoryDao.upsertCategories(categoriesFromApi.map { it.toEntity() })

        } catch (_: Exception) {
        }


        return categoryDao.getCategories().map { it.toDomainModel() }
    }

    override suspend fun getCategoryDetails(id: Int): Category? {
        TODO("Not yet implemented")
    }
}