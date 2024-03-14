package com.example.myrecipes

import retrofit2.http.GET
import retrofit2.http.Query

interface RetroFitRest {

    @GET("recipes/all")
    suspend fun getAll(@Query("category") category: Categories? = null): ListRecipes

/*    @POST("СТРОКА")
    suspend fun create(@Body user: ListRecipes): Response<ListRecipes>*/


}