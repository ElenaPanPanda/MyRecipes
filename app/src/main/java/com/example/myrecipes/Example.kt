package com.example.myrecipes

val RECIPE_1 = Recipe(
    title = "Title 1",
    image = "https://images.unsplash.com/photo-1502236876560-243e78f715f7?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    ingredients = listOf(
        Ingredient(
            "500g", "ingredient 1"
        ),
        Ingredient(
            "10", "ingredient 2"
        )
    ),
    categories = listOf(
        "vegetables",
        "meat",
        "bakery"
    ),
    instructions = "big instructions for recipe 1"
)

val RECIPE_2 = Recipe(
    title = "Title 2",
    image = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?q=80&w=2080&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    ingredients = listOf(
        Ingredient(
            "500g", "ingredient 1"
        ),
        Ingredient(
            "10", "ingredient 2"
        )
    ),
    categories = listOf(
        "meat",
        "bakery"
    ),
    instructions = "big instructions for recipe 2"
)

val RECIPE_3 = Recipe(
    title = "Title 3",
    image = "https://images.unsplash.com/photo-1586671267731-da2cf3ceeb80?q=80&w=1978&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
    ingredients = listOf(
        Ingredient(
            "500g", "ingredient 1"
        ),
        Ingredient(
            "10", "ingredient 2"
        )
    ),
    categories = listOf(
        "vegetables",
        "meat",
        "bakery"
    ),
    instructions = "big instructions for recipe 3"
)


val EXAMPLE_LIST = ListRecipes(
    listRecipes = listOf(
        RECIPE_1,
        RECIPE_2,
        RECIPE_3
    )
)



