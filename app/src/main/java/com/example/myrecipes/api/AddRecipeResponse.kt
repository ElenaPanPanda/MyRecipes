package com.example.myrecipes.api

import com.example.myrecipes.Recipe
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddRecipeResponse(
    val recipe: Recipe,
    val success: Boolean,
    val message: String
)

@Serializable
data class ListRecipesResponse(
    @SerialName("recipes") val listRecipes: List<Recipe>
)