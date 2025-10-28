package com.alica.jokeapp.data.repository

import com.alica.jokeapp.data.model.Joke
import com.alica.jokeapp.data.network.RetrofitInstance

class JokeRepository {

    private val apiService = RetrofitInstance.api

    private var cachedJokes : List<Joke> = emptyList()

    suspend fun getAllJokes() : List<Joke>{
        if (cachedJokes.isEmpty()){
            cachedJokes = apiService.getAllJokes()
        }
        return cachedJokes
    }

    suspend fun refreshJokes(): List<Joke>{
        cachedJokes = apiService.getAllJokes()
        return cachedJokes
    }
}