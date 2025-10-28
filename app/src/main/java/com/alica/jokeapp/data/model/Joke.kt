package com.alica.jokeapp.data.model

data class Joke(
    val id: Int,
    val category: String,
    val type: String,

    val joke: String?,

    val setup: String?,
    val delivery: String?,

    val safe: Boolean
)
