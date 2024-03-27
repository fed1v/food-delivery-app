package com.ivan.fooddelivery.domain.repository

import com.ivan.fooddelivery.domain.models.Category

interface CategoryRepository {

    suspend fun getCategories(): List<Category>

    suspend fun getCategoryDetails(id: Int): Category?
}