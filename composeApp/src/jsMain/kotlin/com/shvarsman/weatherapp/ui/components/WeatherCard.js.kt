package com.shvarsman.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shvarsman.weatherapp.model.WeatherResponse

@Composable
actual fun WeatherCard(weather: WeatherResponse) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(4.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("${weather.main.temp}°C", fontWeight = FontWeight.Bold)
            Text(weather.weather[0].description)
            Text("Влажность: ${weather.main.humidity}%")
            Text("Ветер: ${weather.wind.speed} м/с")
        }
    }
}