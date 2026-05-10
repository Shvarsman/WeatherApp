package com.shvarsman.weatherapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shvarsman.weatherapp.viewmodel.WeatherViewModel
import com.shvarsman.weatherapp.ui.components.SearchField
import com.shvarsman.weatherapp.ui.components.WeatherCard

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val state by viewModel.state.collectAsState()
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchField(onSearch = { viewModel.searchCity(it) })
            Spacer(Modifier.height(12.dp))
            when {
                state.isLoading -> CircularProgressIndicator()
                state.weather != null -> WeatherCard(state.weather!!)
                state.error != null -> Text(
                    text = state.error!!,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}