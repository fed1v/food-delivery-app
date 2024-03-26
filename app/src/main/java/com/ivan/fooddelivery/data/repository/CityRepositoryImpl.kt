package com.ivan.fooddelivery.data.repository

import com.ivan.fooddelivery.domain.models.City
import com.ivan.fooddelivery.domain.repository.CityRepository

class CityRepositoryImpl : CityRepository {
    override fun getCities(): List<City> {
        return listOf(
            City(1, "Москва"),
            City(2, "Санкт-Петербург"),
            City(3, "Екатеринбург"),
        )
    }
}