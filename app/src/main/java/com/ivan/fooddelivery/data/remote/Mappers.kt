package com.ivan.fooddelivery.data.remote

import com.ivan.fooddelivery.data.remote.dto.CategoryDto
import com.ivan.fooddelivery.data.remote.dto.FoodDto
import com.ivan.fooddelivery.domain.models.Category
import com.ivan.fooddelivery.domain.models.Food
import java.util.Locale

fun CategoryDto.toDomainModel(): Category {
    return Category(
        id = idCategory.toInt(),
        name = strCategory
    )
}

fun FoodDto.toDomainModel(): Food {
    val ingredients = mutableListOf<String>()

    val id = idMeal.toInt()

    if (!strIngredient1.isNullOrBlank()) ingredients.add(strIngredient1.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
    })

    if (!strIngredient2.isNullOrBlank()) ingredients.add(strIngredient2)
    if (!strIngredient3.isNullOrBlank()) ingredients.add(strIngredient3)
    if (!strIngredient4.isNullOrBlank()) ingredients.add(strIngredient4)
    if (!strIngredient5.isNullOrBlank()) ingredients.add(strIngredient5)
    if (!strIngredient6.isNullOrBlank()) ingredients.add(strIngredient6)
    if (!strIngredient7.isNullOrBlank()) ingredients.add(strIngredient7)
    if (!strIngredient8.isNullOrBlank()) ingredients.add(strIngredient8)
    if (!strIngredient9.isNullOrBlank()) ingredients.add(strIngredient9)
    if (!strIngredient10.isNullOrBlank()) ingredients.add(strIngredient10)
    if (!strIngredient11.isNullOrBlank()) ingredients.add(strIngredient11)
    if (!strIngredient12.isNullOrBlank()) ingredients.add(strIngredient12)
    if (!strIngredient13.isNullOrBlank()) ingredients.add(strIngredient13)
    if (!strIngredient14.isNullOrBlank()) ingredients.add(strIngredient14)
    if (!strIngredient15.isNullOrBlank()) ingredients.add(strIngredient15)
    if (!strIngredient16.isNullOrBlank()) ingredients.add(strIngredient16)
    if (!strIngredient17.isNullOrBlank()) ingredients.add(strIngredient17)
    if (!strIngredient18.isNullOrBlank()) ingredients.add(strIngredient18)
    if (!strIngredient19.isNullOrBlank()) ingredients.add(strIngredient19)
    if (!strIngredient20.isNullOrBlank()) ingredients.add(strIngredient20)

    return Food(
        id = id,
        imageLink = strMealThumb,
        ingredients = ingredients,
        price = id.toDouble(),
        title = strMeal
    )
}
