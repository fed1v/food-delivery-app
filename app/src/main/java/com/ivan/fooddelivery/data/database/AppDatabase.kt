package com.ivan.fooddelivery.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ivan.fooddelivery.data.database.dao.CategoryDao
import com.ivan.fooddelivery.data.database.dao.FoodDao
import com.ivan.fooddelivery.data.database.entities.CategoryEntity
import com.ivan.fooddelivery.data.database.entities.FoodEntity

@Database(
    version = 1,
    entities = [FoodEntity::class, CategoryEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun foodDao(): FoodDao

    abstract fun categoryDao(): CategoryDao
}