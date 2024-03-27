package com.ivan.fooddelivery.data.remote

import com.ivan.fooddelivery.data.remote.dto.CategoriesResponse
import com.ivan.fooddelivery.data.remote.dto.FoodListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApiService {
    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }

    @GET("categories.php")
    suspend fun getCategories(): Response<CategoriesResponse>

    @GET("search.php")
    suspend fun getFoodList(@Query("f") firstLetter: String): Response<FoodListResponse>
}