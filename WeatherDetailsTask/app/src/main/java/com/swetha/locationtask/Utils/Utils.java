package com.swetha.locationtask.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import com.swetha.locationtask.Listener.WeatherResponseListener;
import com.swetha.locationtask.Rest.ApiClient;
import retrofit2.Retrofit;

public class Utils {



    private static Utils instance = null;

    public static Utils getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new Utils() : instance;
            }
        }
        return instance;
    }

    private Utils() {

    }


    public boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
