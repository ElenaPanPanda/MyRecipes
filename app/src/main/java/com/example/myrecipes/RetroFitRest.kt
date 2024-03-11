package com.example.myrecipes

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetroFitRest {

    @GET("СТРОКА")
    suspend fun getAll(@Body user: ListRecipes): Response<ListRecipes>

    @POST("СТРОКА")
    suspend fun create(@Body user: ListRecipes): Response<ListRecipes>

}