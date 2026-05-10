package com.shvarsman.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.shvarsman.weatherapp.cache.Cache
import com.shvarsman.weatherapp.ui.WeatherScreen
import com.shvarsman.weatherapp.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Cache.appContext = applicationContext
        enableEdgeToEdge()
        setContent {
            WeatherScreen(viewModel = WeatherViewModel())
        }
    }
}