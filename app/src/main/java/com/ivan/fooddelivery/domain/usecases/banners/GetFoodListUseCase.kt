package com.ivan.fooddelivery.domain.usecases.banners

import com.ivan.fooddelivery.domain.models.Food
import com.ivan.fooddelivery.domain.repository.FoodRepository

class GetFoodListUseCase(
    private val foodRepository: FoodRepository
) {

    operator fun invoke(): List<Food> {
        return foodRepository.getFoodList()
    }
}