package com.ivan.fooddelivery.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class FoodEntity(
    @PrimaryKey
    val id: Int,

    val title: String,
    val imageLink: String,
    val ingredients: String,
    val price: Double
)