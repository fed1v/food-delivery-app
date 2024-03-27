package com.ivan.fooddelivery.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ivan.fooddelivery.data.database.entities.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    suspend fun getCategories(): List<CategoryEntity>

    @Upsert
    suspend fun upsertCategories(categories: List<CategoryEntity>)
}