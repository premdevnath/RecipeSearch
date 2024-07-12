package com.example.aiapi.ai

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fooditem")
data class Meal(
    @PrimaryKey(autoGenerate = true)
    val foodid:Int,
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)