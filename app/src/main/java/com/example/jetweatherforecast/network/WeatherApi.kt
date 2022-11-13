package com.example.jetweatherforecast.network

import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.utils.Constants.API_KEY
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
interface WeatherApi {
    @GET(value = "data/2.5/forecast/daily")

     suspend fun getWeather(
    @Query("q") query:String,
    @Query("units") units:String="imperial",
    @Query("appid") appid:String=API_KEY

    ):Weather
}
