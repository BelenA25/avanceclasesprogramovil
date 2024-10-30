package com.example.myapplicationui.navigation

import Movie
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplicationui.screen.MovieDetailScreen
import com.example.myapplicationui.screen.MoviesScreen
import kotlinx.serialization.json.Json

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.MoviesScreen.route
    ) {
        composable(Screens.MoviesScreen.route) {
            MoviesScreen(
                onClick = {
                    movie ->
                    navController.navigate(Screens.MovieDetailScreen.createRoute(movie))
                }
            )
        }

        composable(
            route = Screens.MovieDetailScreen.route,
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ) { backStackEntry ->
            val movieJson = backStackEntry.arguments?.getString("movie") ?: ""
            val movie = Json.decodeFromString<Movie>(movieJson)

            MovieDetailScreen(
                movie = movie,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}