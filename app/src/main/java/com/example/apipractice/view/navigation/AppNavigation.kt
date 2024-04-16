package com.example.apipractice.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.apipractice.view.screens.AboutScreen
import com.example.apipractice.view.screens.ListScreen
import com.example.apipractice.view.screens.MainScreen
import com.example.apipractice.view.screens.RecipeScreen
import com.example.apipractice.viewmodel.MealViewModel

@Composable
fun AppNavigation(viewModel: MealViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route) {
        composable(route = AppScreens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = AppScreens.RandomRecipeScreen.route) {
            RecipeScreen(
                navController = navController,
                isRandomRecipe = true,
                mealViewModel = viewModel,
                idMeal = null
            )
        }
        composable(
            route = "recipe_screen/{idMeal}",
            arguments = listOf(navArgument("idMeal") { type = NavType.StringType })
        )
        { backStackEntry ->
            RecipeScreen(
                navController = navController,
                isRandomRecipe = false,
                mealViewModel = viewModel,
                idMeal = backStackEntry.arguments?.getString("idMeal")
            )
        }
        composable(route = AppScreens.ListScreen.route) {
            ListScreen(
                navController = navController,
            )
        }
        composable(route = AppScreens.AboutScreen.route) {
            AboutScreen(
                navController = navController,
            )
        }
    }
}