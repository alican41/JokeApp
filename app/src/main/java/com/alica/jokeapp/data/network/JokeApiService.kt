package com.alica.jokeapp.data.network

import com.alica.jokeapp.data.model.Joke
import retrofit2.http.GET

interface JokeApiService {


    //atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json

    @GET("atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json")
    suspend fun getAllJokes() : List<Joke>

}