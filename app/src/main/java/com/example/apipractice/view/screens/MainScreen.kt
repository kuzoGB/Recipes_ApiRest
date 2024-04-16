package com.example.apipractice.view.screens

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.apipractice.R
import com.example.apipractice.ui.animations.pressClickEffect
import com.example.apipractice.view.navigation.AppScreens


@Composable
fun MainScreen(navController: NavController) {
    val activity = (LocalContext.current as? Activity)
    BackHandler(
        enabled = true,
        onBack = {
            activity?.finish()
        }
    )


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.purple_200)
    ) {
        MainView(navController)
        AboutText(navController)
    }
}


@Composable
private fun MainView(navController: NavController) {
    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {
                navController.navigate(AppScreens.RandomRecipeScreen.route)
            },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.purple_500)),
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .pressClickEffect(),
            border = BorderStroke(1.dp, colorResource(id = R.color.teal_200))
        ) {
            Text(text = "Get Random Recipe", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {
                navController.navigate(AppScreens.ListScreen.route)
            },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.purple_500)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .pressClickEffect(),
            border = BorderStroke(1.dp, colorResource(id = R.color.teal_200))
        ) {
            Text(text = "My Saved Recipes", color = Color.White)
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}

@Composable
private fun AboutText(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "About",
            color = Color.Blue,
            modifier = Modifier.clickable(
                onClick = {
                    navController.navigate(AppScreens.AboutScreen.route)
                })
        )
    }
}