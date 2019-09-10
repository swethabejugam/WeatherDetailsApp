package com.swetha.locationtask.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ForecastDetailsList {

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @SerializedName("dt")
    private int dt;


    @SerializedName("main")
    private Main main;


    @SerializedName("weather")
    private ArrayList<Weather> weather;

    @SerializedName("dt_txt")
    private String dt_txt;


}
