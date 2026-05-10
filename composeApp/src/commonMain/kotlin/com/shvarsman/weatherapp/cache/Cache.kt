package com.shvarsman.weatherapp.cache

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class Cache() {
    suspend fun save(key: String, data: String)
    suspend fun load(key: String): String?
}