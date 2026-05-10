package com.shvarsman.weatherapp.ui.components

import androidx.compose.runtime.Composable

@Composable
expect fun SearchField(onSearch: (String) -> Unit)