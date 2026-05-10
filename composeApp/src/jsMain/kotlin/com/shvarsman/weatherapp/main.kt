package com.shvarsman.weatherapp

import com.shvarsman.weatherapp.ui.WeatherScreen
import com.shvarsman.weatherapp.viewmodel.WeatherViewModel
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        WeatherScreen(viewModel = WeatherViewModel())
    }
}