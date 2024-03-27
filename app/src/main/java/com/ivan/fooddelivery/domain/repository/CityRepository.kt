package com.ivan.fooddelivery.domain.repository

import com.ivan.fooddelivery.domain.models.City

interface CityRepository {

    suspend fun getCities(): List<City>
}