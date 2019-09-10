package com.swetha.locationtask;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class WeatherDetailsBinding extends BaseObservable {
    private String weatherDetails,weatherForecastDetails,location;
    @Bindable
    public String getWeatherDetails() {
        return weatherDetails;
    }

    void setWeatherDetails(String weatherDetails) {
        this.weatherDetails = weatherDetails;
        notifyPropertyChanged(BR.weatherDetails);
    }
    @Bindable
    public String getWeatherForecastDetails() {
        return weatherForecastDetails;
    }

    void setWeatherForecastDetails(String weatherForecastDetails) {
        this.weatherForecastDetails = weatherForecastDetails;
        notifyPropertyChanged(BR.weatherForecastDetails);
    }
    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }




}
