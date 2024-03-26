package com.ivan.fooddelivery.domain.usecases.banners

import com.ivan.fooddelivery.domain.models.Category
import com.ivan.fooddelivery.domain.repository.CategoryRepository

class GetCategoriesUseCase(
    private val categoryRepository: CategoryRepository
) {

    operator fun invoke(): List<Category> {
        return categoryRepository.getCategories()
    }
}