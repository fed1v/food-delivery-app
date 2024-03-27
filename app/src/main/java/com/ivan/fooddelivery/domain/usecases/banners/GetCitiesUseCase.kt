package com.ivan.fooddelivery.domain.usecases.banners

import com.ivan.fooddelivery.domain.models.City
import com.ivan.fooddelivery.domain.repository.CityRepository

class GetCitiesUseCase(
    private val cityRepository: CityRepository
) {

    suspend operator fun invoke(): List<City> {
        return cityRepository.getCities()
    }
}