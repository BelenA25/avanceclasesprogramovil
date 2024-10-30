package com.example.myapplicationui.navigation

sealed class Screens(val route: String) {
    object MoviesScreen : Screens("movies")
    object MovieDetailScreen : Screens("moviedetail")

    fun createRoute(movieJson: String): String {
        return "movieDetail/$movieJson"
    }
}