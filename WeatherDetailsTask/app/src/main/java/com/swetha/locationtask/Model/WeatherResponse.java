package com.swetha.locationtask.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherResponse {

    @SerializedName("base")
    private String base;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getCod() {
//        return cod;
//    }
//
//    public void setCod(int cod) {
//        this.cod = cod;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }


    @SerializedName("visibility")
    private int visibility;

    @SerializedName("dt")
    private int dt;

    @SerializedName("id")
    private int id;

//    @SerializedName("cod")
//    private int cod;

    @SerializedName("name")
    private String name;

    @SerializedName("weather")
    private ArrayList<Weather> weather=new ArrayList();


    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @SerializedName("coord")
    private Coord coord;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @SerializedName("main")
    private Main main;

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @SerializedName("sys")
    private Sys sys;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @SerializedName("cod")
    private int cod;


}
