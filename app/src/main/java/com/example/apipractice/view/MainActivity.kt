package com.example.apipractice.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.apipractice.R
import com.example.apipractice.view.navigation.AppNavigation
import com.example.apipractice.viewmodel.MealViewModel
import com.example.compose.ApiPracticeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MealViewModel by viewModels()
        setContent {
            ApiPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.purple_200)
                ) {
                    AppNavigation(viewModel)
                }
            }
        }
    }
}