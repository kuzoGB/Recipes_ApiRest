package com.example.apipractice.view.screens

import JsonConvertor
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apipractice.model.data.mealModel.MealX

@Composable
fun ListScreen(navController: NavController) {
    val context = LocalContext.current
    MealList(getAllMealsInData(context), navController)
}

fun getAllMealsInData(context: Context): List<MealX> {
    return JsonConvertor.getMealsList(context)
}

@Composable
fun MealList(mealList: List<MealX>, navController: NavController) {
    LazyColumn {
        items(mealList) { meal ->
            RecipeItemList(
                mealToShow = meal,
                navController = navController
            )
        }
    }
}


@Composable
fun RecipeItemList(
    mealToShow: MealX,
    navController: NavController
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                JsonConvertor.readRecipe(context, mealToShow.idMeal!!)
                navController.navigate("recipe_screen/${mealToShow.idMeal}")
            }
    ) {
        Text(
            text = mealToShow.strMeal!!, fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/*
@Preview
@Composable
fun PreviewList() {
    val meal = MealX(
        dateModified = "2022-01-01",
        idMeal = "123456",
        strArea = "Mexican",
        strCategory = "CHICKEN",
        strCreativeCommonsConfirmed = "Yes",
        strDrinkAlternate = "No",
        strImageSource = "https://www.themealdb.com/images/media/meals/urtpqw1487341253.jpg",
        strIngredient1 = "Ingredient 1",
        strIngredient2 = "Ingredient 2",
        strIngredient3 = "Ingredient 3",
        strMeasure1 = "1 cup",
        strMeasure2 = "2 tablespoons",
        strInstructions = "In a medium saucepan, stir the clotted cream, butter and cornflour over a low-ish heat and bring to a low simmer. Turn off the heat and keep warm.\r\nMeanwhile, put the cheese and nutmeg in a small bowl and add a good grinding of black pepper, then stir everything together (don’t add any salt at this stage).\r\nPut the pasta in another pan with 2 tsp salt, pour over some boiling water and cook following pack instructions (usually 3-4 mins). When cooked, scoop some of the cooking water into a heatproof jug or mug and drain the pasta, but not too thoroughly.\r\nAdd the pasta to the pan with the clotted cream mixture, then sprinkle over the cheese and gently fold everything together over a low heat using a rubber spatula. When combined, splash in 3 tbsp of the cooking water. At first, the pasta will look wet and sloppy: keep stirring until the water is absorbed and the sauce is glossy. Check the seasoning before transferring to heated bowls. Sprinkle over some chives or parsley, then serve immediately.",
        strMeal = "Example Meal",
        strMealThumb = "https://example.com/thumb.jpg",
        strSource = "https://example.com/recipe",
        strTags = "Easy, Quick",
        strYoutube = "https://youtube.com/example",
        strMeasure3 = "una pizca",
        strMeasure11 = "",
        strMeasure12 = "",
        strMeasure13 = "",
        strMeasure14 = "",
        strMeasure15 = "",
        strMeasure16 = "",
        strMeasure17 = "",
        strMeasure18 = "",
        strMeasure19 = "",
        strMeasure20 = "",
        strMeasure4 = "",
        strMeasure5 = "",
        strMeasure6 = "",
        strMeasure7 = "",
        strMeasure8 = "",
        strMeasure9 = "",
        strIngredient11 = "",
        strIngredient12 = "",
        strIngredient13 = "",
        strIngredient14 = "",
        strIngredient15 = "",
        strIngredient16 = "",
        strIngredient17 = "",
        strIngredient18 = "",
        strIngredient19 = "",
        strIngredient20 = "",
        strIngredient4 = "",
        strIngredient5 = "",
        strIngredient6 = "",
        strIngredient7 = "",
        strIngredient8 = "",
        strIngredient9 = "",
        strIngredient10 = "",
        strMeasure10 = "",
        ingredients = mutableListOf()
    )

    val meal2 = MealX(
        dateModified = "2022-01-01",
        idMeal = "123456",
        strArea = "EEEEE",
        strCategory = "AAAAA",
        strCreativeCommonsConfirmed = "Yes",
        strDrinkAlternate = "No",
        strImageSource = "https://www.themealdb.com/images/media/meals/kos9av1699014767.jpg",
        strIngredient1 = "Ingredient 1",
        strIngredient2 = "Ingredient 2",
        strIngredient3 = "Ingredient 3",
        strMeasure1 = "1 cup",
        strMeasure2 = "2 tablespoons",
        strInstructions = "In a medium saucepan, stir the clotted cream, butter and cornflour over a low-ish heat and bring to a low simmer. Turn off the heat and keep warm.\r\nMeanwhile, put the cheese and nutmeg in a small bowl and add a good grinding of black pepper, then stir everything together (don’t add any salt at this stage).\r\nPut the pasta in another pan with 2 tsp salt, pour over some boiling water and cook following pack instructions (usually 3-4 mins). When cooked, scoop some of the cooking water into a heatproof jug or mug and drain the pasta, but not too thoroughly.\r\nAdd the pasta to the pan with the clotted cream mixture, then sprinkle over the cheese and gently fold everything together over a low heat using a rubber spatula. When combined, splash in 3 tbsp of the cooking water. At first, the pasta will look wet and sloppy: keep stirring until the water is absorbed and the sauce is glossy. Check the seasoning before transferring to heated bowls. Sprinkle over some chives or parsley, then serve immediately.",
        strMeal = "Other Meal",
        strMealThumb = "https://example.com/thumb.jpg",
        strSource = "https://example.com/recipe",
        strTags = "Easy, Quick",
        strYoutube = "https://youtube.com/example",
        strMeasure3 = "una pizca",
        strMeasure11 = "",
        strMeasure12 = "",
        strMeasure13 = "",
        strMeasure14 = "",
        strMeasure15 = "",
        strMeasure16 = "",
        strMeasure17 = "",
        strMeasure18 = "",
        strMeasure19 = "",
        strMeasure20 = "",
        strMeasure4 = "",
        strMeasure5 = "",
        strMeasure6 = "",
        strMeasure7 = "",
        strMeasure8 = "",
        strMeasure9 = "",
        strIngredient11 = "",
        strIngredient12 = "",
        strIngredient13 = "",
        strIngredient14 = "",
        strIngredient15 = "",
        strIngredient16 = "",
        strIngredient17 = "",
        strIngredient18 = "",
        strIngredient19 = "",
        strIngredient20 = "",
        strIngredient4 = "",
        strIngredient5 = "",
        strIngredient6 = "",
        strIngredient7 = "",
        strIngredient8 = "",
        strIngredient9 = "",
        strIngredient10 = "",
        strMeasure10 = "",
        ingredients = mutableListOf()
    )

    val mealList: List<MealX> = mutableListOf(meal, meal2)

    MealList(mealList, navController)
} */