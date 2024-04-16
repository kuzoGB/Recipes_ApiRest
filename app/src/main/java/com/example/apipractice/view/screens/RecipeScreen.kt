package com.example.apipractice.view.screens

import JsonConvertor
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.RoundedCornersTransformation
import com.example.apipractice.R
import com.example.apipractice.model.data.mealModel.MealX
import com.example.apipractice.ui.animations.pressClickEffect
import com.example.apipractice.view.navigation.AppScreens
import com.example.apipractice.viewmodel.MealViewModel
import kotlinx.coroutines.runBlocking

@Composable
fun RecipeScreen(
    navController: NavController,
    isRandomRecipe: Boolean,
    mealViewModel: MealViewModel,
    idMeal: String?
) {
    val meal by mealViewModel.recipesModel.observeAsState()
    val isLoading by mealViewModel.loading.observeAsState(initial = true)

    BackHandler(enabled = true, onBack = { navController.navigate(AppScreens.MainScreen.route) })

    LaunchedEffect(Unit) {
        if (isRandomRecipe) {
            mealViewModel.randomRecipe()
        } else {
            mealViewModel.selectedRecipe(idMeal!!)
        }
    }

    if (isLoading) {
        LoadingScreen()
    } else {
        RecipeCard(navController = navController, meal!!, isRandomRecipe, mealViewModel)
    }
}


@Composable
private fun LoadingScreen() {

    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "LOADING...", fontSize = 18.sp, color = Color.DarkGray
        )
    }
}


@Composable
fun RecipeCard(
    navController: NavController, meal: MealX, isRandomRecipe: Boolean, mealViewModel: MealViewModel
) {
    Scaffold(floatingActionButton = { CustomFAB(meal, isRandomRecipe) },

        content = { padding ->
            RecipeContent(
                navController = navController,
                padding = padding,
                meal = meal,
                isRandomRecipe = isRandomRecipe,
                mealViewModel = mealViewModel
            )
        })
}


@Composable
fun CustomFAB(meal: MealX, isRandomRecipe: Boolean) {
    val context = LocalContext.current
    var isPressed = false

    if (isRandomRecipe) {
        FloatingActionButton(
            onClick = {
                if (!isPressed) {
                    isPressed = false
                    Toast.makeText(context, "SAVED", Toast.LENGTH_SHORT).show()
                    JsonConvertor.saveRecipe(context, meal, meal.idMeal!!)
                }
            },
            Modifier.pressClickEffect(),
            contentColor = colorResource(id = R.color.white),
            containerColor = colorResource(id = R.color.purple_500)
        ) {
            Text(
                fontSize = 24.sp, text = "+"
            )
        }
    }
}

@Composable
fun RecipeContent(
    navController: NavController,
    padding: PaddingValues,
    meal: MealX,
    isRandomRecipe: Boolean,
    mealViewModel: MealViewModel
) {
    Surface(
        color = colorResource(id = R.color.purple_200),
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(
                ScrollState(0)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Log.d("RECIPE", meal.toString())

            //RECIPE TITLE
            Text(
                text = meal.strMeal!!,
                color = colorResource(id = R.color.white),
                fontSize = 26.sp,
                modifier = Modifier.padding(top = 24.dp, bottom = 10.dp),
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.height(10.dp))

            //IMAGE
            MealImage(meal.strMealThumb!!)
            Spacer(modifier = Modifier.height(2.dp))

            //TAG
            Text(text = meal.strCategory!!, fontFamily = FontFamily.Monospace)
            Spacer(modifier = Modifier.height(3.dp))


            //COUNTRY
            Text(text = meal.strArea!!, fontFamily = FontFamily.Monospace)
            Spacer(modifier = Modifier.height(8.dp))

            //INGREDIENTES
            Text(
                "INGREDIENTS:",
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.white),
                fontSize = 18.sp
            )
            Surface(
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 8.dp,
                color = colorResource(id = R.color.teal_200),
                border = BorderStroke(2.dp, Color.LightGray),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)

            ) {
                SetIngredients(meal)
            }

            //INSTRUCTIONS
            Text(
                text = "INSTRUCTIONS:",
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.white),
                fontSize = 18.sp
            )
            Surface(
                shape = RoundedCornerShape(12.dp),
                shadowElevation = 8.dp,
                color = colorResource(id = R.color.teal_200),
                border = BorderStroke(2.dp, Color.LightGray),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Column(Modifier.padding(4.dp)) {
                    Text(
                        text = meal.strInstructions!!,
                        modifier = Modifier.padding(6.dp),
                        color = colorResource(id = R.color.white)
                    )
                }
            }

            //OTHER RECIPE BUTTON
            if (isRandomRecipe) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(18.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    OutlinedButton(colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.purple_500),
                    ),
                        modifier = Modifier.pressClickEffect(),
                        border = BorderStroke(1.dp, colorResource(id = R.color.teal_200)),
                        onClick = { runBlocking { mealViewModel.randomRecipe() } }) {
                        Text(text = "Other Recipe", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
private fun MealImage(urlImage: String) {
    val model = ImageRequest.Builder(LocalContext.current).data(urlImage).size(Size.ORIGINAL)
        .transformations(RoundedCornersTransformation()).crossfade(true).build()

    val painter = rememberAsyncImagePainter(model = model)

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun SetIngredients(meal: MealX) {
    meal.setIngredients()

    Column(Modifier.padding(4.dp)) {
        for (ingredient in meal.ingredients!!) {
            if (ingredient.ingredientName.isNotEmpty()) {
                Text(
                    text = "${ingredient.ingredientName} - ${ingredient.ingredientMeasure}",
                    modifier = Modifier.padding(6.dp),
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}


/*@Preview
@Composable
private fun CardPreview() {
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

    RecipeCard(meal, true)
} */