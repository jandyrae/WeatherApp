package com.example.weatherapp;

public class WeatherDescription {
    private String description;
    @Override
    public String toString() {
        return "WeatherDescription{" +
                "description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }


}

