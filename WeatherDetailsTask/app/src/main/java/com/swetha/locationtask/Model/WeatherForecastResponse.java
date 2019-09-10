package com.swetha.locationtask.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherForecastResponse {

    @SerializedName("cod")
   private String cod;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<ForecastDetailsList> getList() {
        return list;
    }

    public void setList(ArrayList<ForecastDetailsList> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @SerializedName("message")
    private Float message;

    @SerializedName("cnt")
    private int cnt;

    @SerializedName("list")
    private ArrayList<ForecastDetailsList> list;

    @SerializedName("city")
    private City city;


}
