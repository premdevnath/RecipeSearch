package com.example.aiapi

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_table")
data class ResultX(

   @PrimaryKey (autoGenerate = true)
   val id: Int=0,
    val image: String,
    val imageType: String,
    val title: String
)