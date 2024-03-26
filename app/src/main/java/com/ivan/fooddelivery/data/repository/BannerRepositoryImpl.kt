package com.ivan.fooddelivery.data.repository

import com.ivan.fooddelivery.data.BannerProvider
import com.ivan.fooddelivery.domain.models.Banner
import com.ivan.fooddelivery.domain.repository.BannerRepository

class BannerRepositoryImpl : BannerRepository {

    override fun getBanners(): List<Banner> {
        return BannerProvider.banners;
    }

    override fun getBannerDetails(id: Int): Banner? {
        return BannerProvider.banners.firstOrNull { it.id == id }
    }
}