package com.example.aiapi.ai

import com.example.aiapi.result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("recipes/complexSearch")
    suspend fun getMeals( @Query("apiKey") apiKey: String): result
}
