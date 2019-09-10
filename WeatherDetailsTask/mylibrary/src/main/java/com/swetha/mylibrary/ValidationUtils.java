package com.swetha.mylibrary;

import android.content.Context;
import android.widget.Toast;

public class ValidationUtils {

    private static ValidationUtils instance;
private ValidationUtils(){

}
    public static ValidationUtils getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new ValidationUtils() : instance;
            }
        }
        return instance;
    }

    public boolean isValidString(String location) {
        return location.length() > 1 ? true : false;
    }
    public void showToast(Context context, String message){
        Toast.makeText(context,message, Toast.LENGTH_LONG).show();

    }
}
