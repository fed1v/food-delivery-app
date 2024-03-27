package com.ivan.fooddelivery.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ivan.fooddelivery.data.database.entities.FoodEntity

@Dao
interface FoodDao {

    @Query("SELECT * FROM food")
    suspend fun getAllFood(): List<FoodEntity>

    @Upsert
    suspend fun upsertFoodList(foodList: List<FoodEntity>)
}