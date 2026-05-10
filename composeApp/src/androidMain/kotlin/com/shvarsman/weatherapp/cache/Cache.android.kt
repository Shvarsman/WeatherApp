package com.shvarsman.weatherapp.cache

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

actual class Cache {
    companion object {
        lateinit var appContext: Context
    }

    private val prefs: SharedPreferences by lazy {
        appContext.getSharedPreferences("weather_prefs", Context.MODE_PRIVATE)
    }

    actual suspend fun save(key: String, data: String) {
        prefs.edit { putString(key, data) }
    }

    actual suspend fun load(key: String): String? {
        return prefs.getString(key, null)
    }
}