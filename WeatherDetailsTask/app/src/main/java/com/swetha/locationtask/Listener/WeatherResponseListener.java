package com.swetha.locationtask.Listener;

import com.swetha.locationtask.Model.WeatherForecastResponse;

public interface WeatherResponseListener {
    public void getWeatherReponse(com.swetha.locationtask.Model.WeatherResponse weatherResponse);
    public void getWeatherForecastReponse(WeatherForecastResponse weatherForecastResponse);
}
