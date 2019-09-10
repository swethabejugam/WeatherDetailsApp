package com.swetha.locationtask;

import android.app.Application;
import android.content.Context;
import com.swetha.locationtask.Preferences.AppDataPref;
import com.swetha.locationtask.Preferences.AppPreferences;

public class LocationTaskApplication extends Application {
    public static Context mContext;
    private AppPreferences appPreferences;

    public AppPreferences getAppPreferences() {
        return appPreferences;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        appPreferences = AppDataPref.getInstance().getAppPref();
    }
}
