package com.swetha.locationtask.Model;

import com.google.gson.annotations.SerializedName;

public class Coord {


    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    @SerializedName("lon")
    private Float lon;


    @SerializedName("lat")
    private Float lat;

}
