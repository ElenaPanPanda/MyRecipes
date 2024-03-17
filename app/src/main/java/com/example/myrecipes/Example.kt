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
        ),
        Ingredient(
            "42", "safoj[pfoa"
        ),
        Ingredient(
            "456", "sadfaet"
        ),
        Ingredient(
            "7", "aaaaaaaaaaa"
        ),
        Ingredient("999", "ppdkfwasdfwepohionfha;oiuewnpodifhsidapoeiruhgfnjdk;a")
    ),
    rawCategories = listOf(

    ),
    instructions = "In a medium bowl, combine hulled and quartered strawberries, 4 Tbsp sugar and 4 Tbsp liqueur, stir to combine then cover and refrigerate at least 1 hour and up to 2 hours, stirring once or twice.\\nTwo photos of cut strawberries in a bowl with one having sugar being added to the bowl Two photos of cut up strawberries for Strawberry Romanoff Just before serving, in a large mixing bowl, combine 1 cup cold heavy cream and 1/4 cup powdered sugar, and beat with an electric mixer until stiff peaks form.\\nUsing a spatula, fold in 1/4 cup sour cream just until well blended.\\nTo serve, stir strawberries then divide between 6 serving glasses or bowls.\\nYou can spoon a little syrup over the berries if you like.\\nYou can also use this syrup to soak a cake.\\nSpoon cream over strawberries, dividing evenly.\\nYou can also use an ice cream scoop with trigger release for a nice rounded puff of cream.\\nServe right away or chill and enjoy within 2 hours of assembly.\nIn a medium bowl, combine hulled and quartered strawberries, 4 Tbsp sugar and 4 Tbsp liqueur, stir to combine then cover and refrigerate at least 1 hour and up to 2 hours, stirring once or twice.\\nTwo photos of cut strawberries in a bowl with one having sugar being added to the bowl Two photos of cut up strawberries for Strawberry Romanoff Just before serving, in a large mixing bowl, combine 1 cup cold heavy cream and 1/4 cup powdered sugar, and beat with an electric mixer until stiff peaks form.\\nUsing a spatula, fold in 1/4 cup sour cream just until well blended.\\nTo serve, stir strawberries then divide between 6 serving glasses or bowls.\\nYou can spoon a little syrup over the berries if you like.\\nYou can also use this syrup to soak a cake.\\nSpoon cream over strawberries, dividing evenly.\\nYou can also use an ice cream scoop with trigger release for a nice rounded puff of cream.\\nServe right away or chill and enjoy within 2 hours of assembly.\"",
    favorite = false
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
    rawCategories = listOf(

    ),
    instructions = "big instructions for recipe 2",
    favorite = false
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
    rawCategories = listOf(

    ),
    instructions = "big instructions for recipe 3",
    favorite = true
)


val EXAMPLE_LIST = ListRecipes(
    listRecipes = listOf(
        RECIPE_1,
        RECIPE_2,
        RECIPE_3
    )
)




