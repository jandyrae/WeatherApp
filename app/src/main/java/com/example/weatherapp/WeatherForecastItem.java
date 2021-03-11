package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class WeatherForecastItem {
    @SerializedName("dt_txt")
    private String dt_txt;
    @SerializedName("main")
    private Map<String, Float> measurements;
    //    private Map<String, Float> wind;
    @SerializedName("weather")
    private List<WeatherDescription> descriptions;
    private WeatherWind wind;


    // getters for private variables
    public String getDt_txt() {
        return dt_txt;
    }
    public Map<String, Float> getMeasurements() {
        return measurements;
    }
    public List<WeatherDescription> getDescriptions() {
        return descriptions;
    }
    private WeatherWind getWind(){return wind;}

    @Override
    public String toString() {
        return "WeatherForecastItem{" +
                "dt_txt='" + dt_txt + '\'' +
                ", measurements=" + measurements.get("temp_max") + " / "+measurements.get("temp_min")+
                ", wind=" + wind.getSpeed() +
                ", descriptions=" + descriptions.get(0).getDescription() +
                '}';
    }
}
