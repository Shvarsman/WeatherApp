package com.shvarsman.weatherapp.ui.components

import androidx.compose.runtime.Composable
import com.shvarsman.weatherapp.model.WeatherResponse

@Composable
expect fun WeatherCard(weather: WeatherResponse)