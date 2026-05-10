package com.shvarsman.weatherapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform