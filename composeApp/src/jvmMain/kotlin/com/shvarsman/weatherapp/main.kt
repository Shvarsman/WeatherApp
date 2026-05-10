package com.shvarsman.weatherapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.shvarsman.weatherapp.ui.WeatherScreen
import com.shvarsman.weatherapp.viewmodel.WeatherViewModel

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Погода",
        resizable = true
    ) {
        WeatherScreen(WeatherViewModel())
    }
}