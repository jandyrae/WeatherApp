package com.example.weatherapp;

import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class GetForecast implements Runnable{
    private String city;
    private MainActivity mainActivity;
    private WeatherForecast forecast;
    ArrayAdapter<WeatherForecastItem> adapter;

    public GetForecast(MainActivity ma, String city){
    this.mainActivity = ma;
    this.city = city;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void run() {


        WeatherDataLoader weatherDataLoader = new WeatherDataLoader();
        forecast = weatherDataLoader.loadWeatherForecast(city);

        System.out.println("Getting forecast");
        Log.d(getClass().getName(), "Getting forecast for " + city);

        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter = new ArrayAdapter<WeatherForecastItem>(mainActivity, android.R.layout.simple_list_item_1, forecast.list);
                ListView listView = mainActivity.findViewById(R.id.listView);
                listView.setAdapter(adapter);
                Toast toast = Toast.makeText(mainActivity, city, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
