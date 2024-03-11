package com.example.myrecipes

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object ApiRest {
    private const val API_URL = "СТРОКА"
    private val contentType = MediaType.get("application/json")

    val client = Retrofit.Builder()
        .baseUrl(API_URL) // API base URL
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build() // Create Retrofit instance
        .create(RetroFitRest::class.java)
}