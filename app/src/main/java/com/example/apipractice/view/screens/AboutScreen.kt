package com.example.apipractice.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.apipractice.R

@Composable
fun AboutScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.purple_200)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "App created by \nIvan Galacho Bermduez",
                textAlign = TextAlign.Center,
                fontSize = 19.sp
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = "Special thanks to the creator of the API TheMealDB \nwww.themealdb.com",
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }

    }
}

@Preview
@Composable
fun PreviewAboutScreen() {
    val navController = rememberNavController()
    AboutScreen(navController)
}