package com.shvarsman.weatherapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.shvarsman.weatherapp.model.WeatherResponse

@Composable
actual fun WeatherCard(weather: WeatherResponse) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val iconUrl = "https://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png"
            AsyncImage(
                model = iconUrl,
                contentDescription = "Иконка погоды",
                modifier = Modifier.size(80.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "${weather.main.temp}°C",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = weather.weather[0].description.replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("💧 ${weather.main.humidity}%")
                Text("💨 ${weather.wind.speed} м/с")
            }
        }
    }
}