package com.shvarsman.weatherapp.repository

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import com.shvarsman.weatherapp.cache.Cache
import com.shvarsman.weatherapp.model.WeatherResponse
import com.shvarsman.weatherapp.network.WeatherApiService

class WeatherRepository(
    private val api: WeatherApiService = WeatherApiService(),
    private val cache: Cache = Cache(),
    private val apiKey: String = "ca48ac33cfd400962c55723280ee177a"
) {
    suspend fun getWeather(city: String): WeatherResponse {
        val cachedJson = cache.load(city)
        if (cachedJson != null) {
            try {
                return Json.decodeFromString(cachedJson)
            } catch (_: Exception) {
                // Если кеш повреждён, идём дальше в сеть
            }
        }
        val response = api.getWeather(city, apiKey)
        cache.save(city, Json.encodeToString(response))
        return response
    }
}