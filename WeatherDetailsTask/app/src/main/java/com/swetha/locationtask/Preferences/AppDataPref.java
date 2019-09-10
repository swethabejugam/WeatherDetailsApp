package com.swetha.locationtask.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.swetha.locationtask.AdapterModel;
import com.swetha.locationtask.LocationTaskApplication;

import java.util.ArrayList;

public class AppDataPref {

    private final SharedPreferences sharedpreferences;
    private final SharedPreferences.Editor editor;
    private final String MyPREFERENCES = "APP_DATA";
    private final String APP_PREFRENCES = "APP_PREF";
    private static AppDataPref instance = null;

    private AppDataPref() {
        sharedpreferences = LocationTaskApplication.mContext.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }


    public static AppDataPref getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new AppDataPref() : instance;
            }
        }
        return instance;
    }


    public void updateAppPref(AppPreferences appPreferences) {
        SharedPreferences.Editor prefsEditor = sharedpreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(appPreferences);
        prefsEditor.putString(APP_PREFRENCES, json);
        prefsEditor.commit();

    }

    public AppPreferences getAppPref() {
        Gson gson = new Gson();
        String json = gson.toJson(new AppPreferences());
        json = sharedpreferences.getString(APP_PREFRENCES, json);
        AppPreferences obj = gson.fromJson(json, AppPreferences.class);
        return obj;
    }

    public void setLocationsList(ArrayList<AdapterModel> locationList) {
        AppPreferences appPreferences = AppDataPref.getInstance().getAppPref();
        appPreferences.setLocationList(locationList);
        AppDataPref.getInstance().updateAppPref(appPreferences);


    }

    public ArrayList<AdapterModel> getLocationList() {
        AppPreferences appPreferences = AppDataPref.getInstance().getAppPref();
        return appPreferences.getLocationList();

    }
}
