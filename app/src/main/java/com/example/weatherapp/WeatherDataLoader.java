package com.example.weatherapp;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.google.gson.Gson;
import java.nio.charset.StandardCharsets;

public class WeatherDataLoader {

private final String secret = "cec6688f1b2e49611b637187174f926d";
private final String baseUrl = "https://api.openweathermap.org/data/2.5/";

private Gson gson = new Gson();
private HTTPAccess httpAccess = new HTTPAccess();

private final String apiCharset;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public WeatherDataLoader(){
        apiCharset = StandardCharsets.UTF_8.name();
    }
    public WeatherConditions loadCurrentWeather(String city) {
        // Request for weather data
        String url = baseUrl + "weather" +
                "?q=" + city +
                "&units=imperial" +
                "&apiKey=" + secret;
        String data = httpAccess.readHTTP(url);
        // Convert JSON data to WeatherConditions object
        return gson.fromJson(data, WeatherConditions.class);
    }
    public WeatherForecast loadWeatherForecast(String city) {
        // Request for weather forecast
        String url = baseUrl + "forecast" +
                "?q=" + city +
                "&units=imperial" +
                "&apiKey=" + secret;
        String data = httpAccess.readHTTP(url);
        // Convert JSON data to WeatherForecast object
        return gson.fromJson(data, WeatherForecast.class);
    }


}

