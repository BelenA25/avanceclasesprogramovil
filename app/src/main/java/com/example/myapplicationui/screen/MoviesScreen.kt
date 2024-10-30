package com.example.myapplicationui.screen

import Movie
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MoviesScreen(onClick : (Movie) -> Unit) {
    Scaffold(
        content = {
                paddingValues ->
            MoviesScreenContent( modifier = Modifier.padding(paddingValues), onClick = onClick
            )
        }
    )
}


@Composable
fun MoviesScreenContent(
    modifier: Modifier, onClick: (Movie) -> Unit, ) {
    val movie = Movie(id = 1, title = "Inception", description = "A mind-bending thriller")

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onClick(movie) }
        ) {
            Text(text = "Ir al detalle")
        }
    }
}