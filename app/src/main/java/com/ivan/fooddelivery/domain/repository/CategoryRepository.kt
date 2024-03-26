package com.ivan.fooddelivery.domain.repository

import com.ivan.fooddelivery.domain.models.Category

interface CategoryRepository {

    fun getCategories(): List<Category>

    fun getCategoryDetails(id: Int): Category?
}