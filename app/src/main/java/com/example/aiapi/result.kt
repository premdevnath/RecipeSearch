package com.example.aiapi

data class result(
    val number: Int,
    val offset: Int,
    val results: List<ResultX>,
    val totalResults: Int
)