package com.example.myrecipes.data

import android.os.Parcelable
import kotlinx.serialization.*
import kotlinx.parcelize.Parcelize

@Parcelize
@Serializable
data class Recipe(
    val id: String,
    val title: String,
    val image: String,
    val ingredients: List<Ingredient>,
    @SerialName("categories")
    val rawCategories: List<String>,
    val instructions: String,
    var favorite: Boolean
) : Parcelable {
    val categories: List<Category>
        get() = rawCategories.map {
            Category.valueOf(it)
        }

    companion object {
        const val KEY_ARG = "recipe"
    }
}

