package com.example.myrecipes

import kotlinx.serialization.*

@Serializable
data class Recipe(
    val title: String,
    val image: String,
    val ingredients: List<String>,
    val icons: List<String>,
    val instructions: String
)

@Serializable
data class ListRecipes(
    @SerialName("recipes") val listRecipes: List<Recipe>
)