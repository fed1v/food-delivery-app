package com.ivan.fooddelivery.data

import com.ivan.fooddelivery.R
import com.ivan.fooddelivery.domain.models.Banner

object BannerProvider {
    val banners = listOf(
        Banner(1, R.drawable.image_banner_1),
        Banner(2, R.drawable.image_banner_2),
        Banner(3, R.drawable.image_banner_1),
    )
}