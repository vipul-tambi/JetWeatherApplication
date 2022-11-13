package com.example.jetweatherforecast.screens.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository,
                                        @SuppressLint("StaticFieldLeak") @ApplicationContext private val context: Context
)
    :ViewModel(){

    suspend fun getWeatherData(city: String, units: String)
            : DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(cityQuery = city,units=units)

    }
}