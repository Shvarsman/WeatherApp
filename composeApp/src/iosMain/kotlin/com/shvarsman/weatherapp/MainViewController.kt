package com.shvarsman.weatherapp

import androidx.compose.ui.window.ComposeUIViewController
import com.shvarsman.weatherapp.ui.WeatherScreen
import com.shvarsman.weatherapp.viewmodel.WeatherViewModel

fun MainViewController() = ComposeUIViewController {
    WeatherScreen(WeatherViewModel())
}