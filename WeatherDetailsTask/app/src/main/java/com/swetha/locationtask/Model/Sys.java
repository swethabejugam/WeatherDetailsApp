package com.swetha.locationtask.Model;

import com.google.gson.annotations.SerializedName;

public class Sys {
    @SerializedName("type")
    private int type;

    @SerializedName("id")
    private int id;

    @SerializedName("message")
    private Float message;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(double sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private double sunrise;

    @SerializedName("sunset")
    private double sunset;
}
