package com.alica.jokeapp.ui.joke

import com.alica.jokeapp.data.model.Joke

data class JokeUiState(
    val jokes: List<Joke> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
