package com.shvarsman.weatherapp.viewmodel

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.shvarsman.weatherapp.model.WeatherResponse
import com.shvarsman.weatherapp.repository.WeatherRepository

data class WeatherUiState(
    val weather: WeatherResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class WeatherViewModel(
    private val repository: WeatherRepository = WeatherRepository(),
    private val scope: CoroutineScope = MainScope()
) {
    private val _state = MutableStateFlow(WeatherUiState())
    val state: StateFlow<WeatherUiState> = _state.asStateFlow()

    fun searchCity(city: String) {
        _state.update { it.copy(isLoading = true, error = null) }
        scope.launch {
            try {
                val weather = repository.getWeather(city)
                _state.update { it.copy(weather = weather as WeatherResponse?, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message ?: "Ошибка") }
            }
        }
    }

    fun onCleared() {
        scope.cancel()
    }
}