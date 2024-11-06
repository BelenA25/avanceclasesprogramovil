package com.example.myapplicationui
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val title: String,
    val description: String
)
