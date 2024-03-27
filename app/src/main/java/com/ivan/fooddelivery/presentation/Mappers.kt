package com.ivan.fooddelivery.presentation

import com.ivan.fooddelivery.domain.models.Banner
import com.ivan.fooddelivery.domain.models.Category
import com.ivan.fooddelivery.domain.models.City
import com.ivan.fooddelivery.domain.models.Food
import com.ivan.fooddelivery.presentation.models.BannerPresentation
import com.ivan.fooddelivery.presentation.models.CategoryPresentation
import com.ivan.fooddelivery.presentation.models.CityPresentation
import com.ivan.fooddelivery.presentation.models.FoodPresentation

fun Banner.toPresentation(): BannerPresentation {
    return BannerPresentation(
        id = id,
        resource = resource
    )
}

fun Category.toPresentation(): CategoryPresentation {
    return CategoryPresentation(
        id = id,
        name = name
    )
}

fun Food.toPresentation(): FoodPresentation {
    return FoodPresentation(
        id = id,
        imageLink = imageLink,
        title = title,
        ingredients = ingredients.joinToString(", "),
        price = "from ${price.toInt()} rub"
    )
}

fun City.toPresentation(): CityPresentation {
    return CityPresentation(
        id = id,
        name = name
    )
}