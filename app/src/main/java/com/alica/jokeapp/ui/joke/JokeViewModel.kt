package com.alica.jokeapp.ui.joke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alica.jokeapp.data.repository.JokeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    private val repository = JokeRepository()

    private val _uiState = MutableStateFlow(JokeUiState())
    val uiState: StateFlow<JokeUiState> = _uiState.asStateFlow()

    init {
        fetchJokes(isRefresh = false)
    }

    fun fetchJokes(isRefresh: Boolean = false){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            try {
                val jokesList = if (isRefresh){
                    repository.refreshJokes()
                } else {
                    repository.getAllJokes()
                }

                _uiState.update { it.copy(isLoading = false, jokes = jokesList) }

            } catch (e: Exception){
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }


}