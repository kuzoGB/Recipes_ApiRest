package com.example.apipractice.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.apipractice.model.data.RecipesProvider
import com.example.apipractice.model.data.mealModel.MealX
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {

    private var _recipesModel = MutableLiveData<MealX>()
    val recipesModel: LiveData<MealX> get() = _recipesModel

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    suspend fun randomRecipe() {
        _loading.value = true

        viewModelScope.launch {
            try {
                val currentRecipes = RecipesProvider.getRandomRecipeFromAPI()
                _recipesModel.value = currentRecipes
            } catch (e: Exception) {
                Log.e("ERROR_GET_RANDOM_RECIPE", e.message!!)
            } finally {
                _loading.value = false
            }
        }
    }


    fun selectedRecipe(mealId: String) {
        _loading.value = true
        val currentRecipes = RecipesProvider.getRecipeFromAPI(mealId)
        _recipesModel.value = currentRecipes

        _loading.value = false
    }
}

class MealViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MealViewModel() as T
    }
}