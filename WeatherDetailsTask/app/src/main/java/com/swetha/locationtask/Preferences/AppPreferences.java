package com.swetha.locationtask.Preferences;

import com.google.gson.annotations.SerializedName;
import com.swetha.locationtask.AdapterModel;

import java.util.ArrayList;

public class AppPreferences {

    public ArrayList<AdapterModel> getLocationList() {
        return LocationList;
    }

    public void setLocationList(ArrayList<AdapterModel> locationList) {
        LocationList = locationList;
    }

    @SerializedName("LocationList")
    ArrayList<AdapterModel> LocationList=new ArrayList<>();


}
