package com.ivan.fooddelivery.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FoodListResponse(

    @SerializedName("meals")
    val foodList: List<FoodDto>
)