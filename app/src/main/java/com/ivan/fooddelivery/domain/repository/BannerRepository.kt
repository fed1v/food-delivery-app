package com.ivan.fooddelivery.domain.repository

import com.ivan.fooddelivery.domain.models.Banner

interface BannerRepository {

    suspend fun getBanners(): List<Banner>

    suspend fun getBannerDetails(id: Int): Banner?
}