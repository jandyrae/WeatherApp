package com.example.weatherapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public EditText city;
    public List<WeatherForecastItem> forecastList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forecastList = new ArrayList<>();
        city = (EditText) findViewById(R.id.enterCity);
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, forecastList);
//        //  create object for layout
//        ListView view = findViewById(R.id.listView);
//        view.setAdapter(adapter);
    }


    public void currentTemp(View view) {
        GetWeather getWeather = new GetWeather(this, city.getText().toString());
        Thread thread1 = new Thread(getWeather,"thread1");
        thread1.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void weatherForecast(View view) {
        GetForecast getForecast = new GetForecast(this, city.getText().toString());

        Thread thread1 = new Thread(getForecast,"thread1");
        thread1.start();
//        forecastList = new ArrayList<>();

    }
}