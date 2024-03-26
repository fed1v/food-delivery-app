package com.ivan.fooddelivery.domain.repository

import com.ivan.fooddelivery.domain.models.Banner

interface BannerRepository {

    fun getBanners(): List<Banner>

    fun getBannerDetails(id: Int): Banner?
}