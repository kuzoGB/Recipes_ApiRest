package com.example.apipractice.model.data

import com.example.apipractice.model.data.mealModel.Meal
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("https://www.themealdb.com/api/json/v1/1/random.php")
    suspend fun getRandomRecipe(): Meal

}

object RetrofitServiceFactory {
    fun getRetrofit(): RetrofitService {
        return Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitService::class.java)
    }
}