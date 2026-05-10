package com.shvarsman.weatherapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shvarsman.weatherapp.model.WeatherResponse

@Composable
actual fun WeatherCard(weather: WeatherResponse) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Погода", fontWeight = FontWeight.Bold)
            Text("${weather.main.temp}°C", fontSize = 28.sp)
            Text(weather.weather[0].description)
            Text("Влажность: ${weather.main.humidity}%")
            Text("Ветер: ${weather.wind.speed} м/с")
        }
    }
}