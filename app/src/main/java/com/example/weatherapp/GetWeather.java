package com.example.weatherapp;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class GetWeather implements Runnable {
    private String city;
    private MainActivity mainActivity;
    private WeatherConditions conditions;

    public GetWeather(MainActivity ma, String city) {
        this.mainActivity = ma;
    this.city = city;

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void run() {

        WeatherDataLoader weatherDataLoader = new WeatherDataLoader();
        conditions = weatherDataLoader.loadCurrentWeather(city);
        Log.d(getClass().getName(), "Getting temperature for " + city);

        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(mainActivity, "Temperature is " +
                        conditions.getMeasurements().get("temp"), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}

