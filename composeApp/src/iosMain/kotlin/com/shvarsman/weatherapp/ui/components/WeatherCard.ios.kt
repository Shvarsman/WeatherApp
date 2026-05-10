package com.shvarsman.weatherapp.ui.components

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
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFF2F2F7),
        shadowElevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("🌤", fontSize = 48.sp) // упрощённая иконка
            Spacer(Modifier.height(8.dp))
            Text("${weather.main.temp}°C", fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Text(weather.weather[0].description.replaceFirstChar { it.uppercase() })
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("Влажность: ${weather.main.humidity}%")
                Text("Ветер: ${weather.wind.speed} м/с")
            }
        }
    }
}