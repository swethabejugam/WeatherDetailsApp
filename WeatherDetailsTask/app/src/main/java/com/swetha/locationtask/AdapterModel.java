package com.swetha.locationtask;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import com.swetha.locationtask.BR;

import java.util.Observable;

public class AdapterModel extends BaseObservable {

    private String Location;
    public AdapterModel(String location){
        this.Location=location;
    }
    @Bindable
    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
        notifyPropertyChanged(BR.location);
    }


}
