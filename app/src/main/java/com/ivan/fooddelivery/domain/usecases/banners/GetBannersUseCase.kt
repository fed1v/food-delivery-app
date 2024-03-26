package com.ivan.fooddelivery.domain.usecases.banners

import com.ivan.fooddelivery.domain.models.Banner
import com.ivan.fooddelivery.domain.repository.BannerRepository

class GetBannersUseCase(
    private val bannerRepository: BannerRepository
) {

    operator fun invoke(): List<Banner> {
        return bannerRepository.getBanners()
    }
}