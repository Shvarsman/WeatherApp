package com.shvarsman.weatherapp.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val main: MainData,
    val weather: List<WeatherCondition>,
    val wind: WindData
)

@Serializable
data class MainData(val temp: Double, val humidity: Int)

@Serializable
data class WeatherCondition(val description: String, val icon: String)

@Serializable
data class WindData(val speed: Double)