package com.ivan.fooddelivery.data.repository

import com.ivan.fooddelivery.domain.models.Category
import com.ivan.fooddelivery.domain.repository.CategoryRepository

class CategoryRepositoryImpl : CategoryRepository {

    override fun getCategories(): List<Category> {
        return listOf(
            Category(1, "Пицца"),
            Category(2, "Комбо"),
            Category(3, "Десерты"),
            Category(4, "Напитки"),
            Category(5, "Завтраки"),
            Category(6, "Обеды"),
        )
    }

    override fun getCategoryDetails(id: Int): Category? {
        TODO("Not yet implemented")
    }
}