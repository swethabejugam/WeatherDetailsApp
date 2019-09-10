package com.swetha.locationtask.Model;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    private Float temp;


    @SerializedName("pressure")
    private float pressure;

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Float temp_max) {
        this.temp_max = temp_max;
    }

    public Float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Float temp_min) {
        this.temp_min = temp_min;
    }

    @SerializedName("humidity")
    private int humidity;


    @SerializedName("temp_max")
    private Float temp_max;

    @SerializedName("temp_min")
    private Float temp_min;


}
