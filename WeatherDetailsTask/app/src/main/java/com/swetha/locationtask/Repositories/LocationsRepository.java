package com.swetha.locationtask.Repositories;

import androidx.lifecycle.MutableLiveData;
import com.swetha.locationtask.AdapterModel;
import com.swetha.locationtask.Preferences.AppDataPref;

import java.util.ArrayList;
import java.util.List;

public class LocationsRepository {

    private static LocationsRepository instance = null;
    private ArrayList<AdapterModel> models = new ArrayList<>();


    public static LocationsRepository getInstance() {
        if (instance == null) {
            instance = new LocationsRepository();
        }
        return instance;
    }

    public MutableLiveData<List<AdapterModel>> getLocationsList() {
        setLocationsList();
        MutableLiveData<List<AdapterModel>> list = new MutableLiveData<>();
        list.setValue(models);
        return list;
    }

    public void setLocationsList() {
       models = AppDataPref.getInstance().getLocationList();
    }

}
