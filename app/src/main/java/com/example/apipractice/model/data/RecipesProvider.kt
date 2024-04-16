package com.example.apipractice.model.data

import JsonConvertor
import android.util.Log
import com.example.apipractice.model.data.mealModel.MealX
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class RecipesProvider {

    companion object {
        suspend fun getRandomRecipeFromAPI(): MealX {
            return suspendCancellableCoroutine { continuation ->
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val service = RetrofitServiceFactory.getRetrofit()
                        val randomRecipe = service.getRandomRecipe()
                        val meal = randomRecipe.meals[0]
                        Log.d("API", meal.toString())
                        continuation.resume(meal)
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }
        }

        fun getRecipeFromAPI(mealId: String): MealX {
            var gettingMeal: MealX?
            while (true) {
                gettingMeal = JsonConvertor.getMealSelected()
                if (gettingMeal != null) break
            }
            return gettingMeal!!
        }
    }
}