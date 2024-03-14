package com.example.myrecipes

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipesApi {

    @GET("recipes/all")
    suspend fun getRecipesList(@Query("category") category: Categories? = null): ListRecipes

    @GET("recipes/{id}")
    suspend fun getRecipe(@Path("id") id: String): Recipe

    @POST("recipes/all")
    suspend fun addRecipe(@Body recipe: Recipe): Recipe

    @PATCH("recipes/{id}")
    suspend fun editRecipe(
        @Path("id") id: String,
        @Body recipe: Recipe
        ): Recipe

    @DELETE("recipes/{id}")
    suspend fun deleteRecipe(@Path("id") id: String): Recipe
}