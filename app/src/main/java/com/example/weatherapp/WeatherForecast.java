package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherForecast {
    @SerializedName("list")
    public List<WeatherForecastItem> list;

    public List<WeatherForecastItem> getForecastItems() {

        return list;

    }
    public void setForecastItems(List<WeatherForecastItem> forecastItems) {
        this.list = forecastItems;
    }

}
