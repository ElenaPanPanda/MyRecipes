package com.example.myrecipes

import kotlinx.serialization.*

@Serializable
data class Ingredient(
    val quantity: String,
    val ingredient: String
)

@Serializable
data class Recipe(
    val title: String,
    val image: String,
    val ingredients: List<Ingredient>,
    val categories: List<Categories>,
    val instructions: String,
    val favorite: Boolean
) {
    /*fun filter(category: Categories): List<Recipe> {

    }*/

}

@Serializable
data class ListRecipes(
    @SerialName("recipes") val listRecipes: List<Recipe>
)