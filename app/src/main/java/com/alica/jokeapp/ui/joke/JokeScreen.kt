package com.alica.jokeapp.ui.joke

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alica.jokeapp.data.model.Joke

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JokeScreen(
    viewModel: JokeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Joke App") },
                actions = {
                    // Yenileme Butonu
                    IconButton(
                        onClick = { viewModel.fetchJokes(isRefresh = true) },
                        enabled = !uiState.isLoading // Yüklenirken butonu kapat
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->

        // Ana içerik alanı
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // TopAppBar'dan gelen padding'i uygula
                .padding(horizontal = 16.dp), // Liste için kenar boşluğu
            contentAlignment = Alignment.Center
        ) {
            when {
                // 1. Yüklenme durumu
                uiState.isLoading -> {
                    CircularProgressIndicator()
                }

                // 2. Hata durumu
                uiState.error != null -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = uiState.error!!,
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { viewModel.fetchJokes(isRefresh = true) }) {
                            Text("Try Again")
                        }
                    }
                }

                // 3. Başarı durumu (Liste boş olsa bile)
                else -> {
                    JokeList(jokes = uiState.jokes)
                }
            }
        }
    }
}

// Tüm şakaları listeleyen LazyColumn
@Composable
fun JokeList(jokes: List<Joke>) {
    if (jokes.isEmpty()) {
        Text("No jokes found to show.")
        return
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp) // Listenin üst ve alt boşluğu
    ) {
        // 'items' fonksiyonu listeyi alır ve her öğe için bir Composable çizer
        // 'key' belirlemek performans için önemlidir.
        items(items = jokes, key = { it.id }) { joke ->
            // Daha önce oluşturduğumuz JokeCard'ı burada yeniden kullanıyoruz
            JokeCard(joke = joke)
        }
    }
}

// Bu Composable HİÇ DEĞİŞMEDİ.
// Tek bir şakayı nasıl göstereceğini zaten biliyor.
@Composable
fun JokeCard(joke: Joke) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            if (joke.type == "single") {
                Text(
                    text = joke.joke!!,
                    fontSize = 18.sp,
                    lineHeight = 24.sp
                )
            } else {
                Text(
                    text = joke.setup!!,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = joke.delivery!!,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Category: ${joke.category}",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}