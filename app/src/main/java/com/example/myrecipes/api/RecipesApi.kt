package com.example.myrecipes.api

import com.example.myrecipes.Category
import com.example.myrecipes.Recipe
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipesApi {

    @GET("recipes")
    suspend fun getRecipesList(@Query("category") category: Category? = null): ListRecipesResponse

    @GET("recipes/{id}")
    suspend fun getRecipe(@Path("id") id: String): Recipe

    @POST("recipes")
    suspend fun addRecipe(@Body recipe: Recipe): AddRecipeResponse

    @PATCH("recipes/{id}")
    suspend fun editRecipe(
        @Path("id") id: String,
        @Body recipe: Recipe
        ): Recipe

    @DELETE("recipes/{id}")
    suspend fun deleteRecipe(@Path("id") id: String): Recipe
}