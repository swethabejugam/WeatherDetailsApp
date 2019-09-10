package com.swetha.locationtask.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.swetha.locationtask.AdapterModel;
import com.swetha.locationtask.Preferences.AppDataPref;
import com.swetha.locationtask.Repositories.LocationsRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<AdapterModel>> modelsLlist;
    private LocationsRepository repo;
    private MutableLiveData<Boolean> mIsUpdating=new MutableLiveData<>();

    public void init(){
        if(modelsLlist!=null){
            return;
        }
        modelsLlist=  repo.getInstance().getLocationsList();
    }
    public LiveData<List<AdapterModel>> getModelsList(){
        return modelsLlist;
    }

    public void setModel(AdapterModel adapterModel){
        mIsUpdating.setValue(true);
        List<AdapterModel> adapterModelList=modelsLlist.getValue();
        adapterModelList.add(adapterModel);
        modelsLlist.postValue(adapterModelList);
        AppDataPref.getInstance().setLocationsList((ArrayList<AdapterModel>) modelsLlist.getValue());
        mIsUpdating.setValue(false);
    }
    public MutableLiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
