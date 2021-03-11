package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

// fields we want from weather API, an int id, a string name, and a list type map with key:value - string:float
public class WeatherConditions {
    private int id;
    private String  name;
    @SerializedName("main")
    private Map<String, Float> measurements;

    @Override
    public String toString() {
        return "WeatherConditions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measurements=" + measurements +
                '}';
    }
// getters for our private variables

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    public WeatherConditions(int id, String name, Map<String, Float> measurements) {
        this.id = id;
        this.name = name;
        this.measurements = measurements;
    }
}
