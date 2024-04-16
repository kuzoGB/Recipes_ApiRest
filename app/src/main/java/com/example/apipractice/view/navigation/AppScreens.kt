package com.example.apipractice.view.navigation

sealed class AppScreens(val route: String) {

    object MainScreen : AppScreens("main_screen")
    object ListScreen : AppScreens("list_screen")
    object RecipeScreen : AppScreens("recipe_screen")
    object RandomRecipeScreen : AppScreens("random_recipe_screen")
    object AboutScreen : AppScreens("about_screen")
}