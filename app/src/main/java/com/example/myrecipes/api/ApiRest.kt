package com.example.myrecipes.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiRest {
    private const val API_URL = "http://147.182.183.243:8080/"
    private val contentType = "application/json".toMediaType()



    val client = Retrofit.Builder()
        .baseUrl(API_URL) // API base URL
        .addConverterFactory(Json{
            ignoreUnknownKeys = true
        }.asConverterFactory(contentType))
        .client(createOkHttpClient())
        .build() // Create Retrofit instance
        .create(RecipesApi::class.java)
}

fun createOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}