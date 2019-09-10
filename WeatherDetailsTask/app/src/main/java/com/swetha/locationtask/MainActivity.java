package com.swetha.locationtask;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.*;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.swetha.locationtask.Adapters.LocationsAdapter;
import com.swetha.locationtask.Listener.WeatherResponseListener;
import com.swetha.locationtask.Model.WeatherForecastResponse;
import com.swetha.locationtask.Model.WeatherResponse;
import com.swetha.locationtask.Rest.ApiClient;
import com.swetha.locationtask.Utils.Utils;
import com.swetha.locationtask.ViewModels.MainActivityViewModel;
import com.swetha.locationtask.databinding.ActivityMainBinding;
import com.swetha.locationtask.databinding.DialogAddLocationBinding;
import com.swetha.mylibrary.ValidationUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements WeatherResponseListener, LocationsAdapter.LocationsAdapterListener {

    private LocationsAdapter locationsAdapter;
    private String location = "";
    private Dialog dialog;
    private ActivityMainBinding activityMainBinding;
    private MyClickHandlers myClickHandlers;
    private DialogAddLocationBinding dialogBinding;
    private MainActivityViewModel mainActivityViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        myClickHandlers = new MyClickHandlers(this);
        activityMainBinding.setHandlers(myClickHandlers);

        /*View Model*/
        mainActivityViewModel=  ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        setViews();
        mainActivityViewModel.getModelsList().observe(this, new Observer<List<AdapterModel>>() {
            @Override
            public void onChanged(List<AdapterModel> adapterModels) {
                locationsAdapter.notifyDataSetChanged();
            }
        });
        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(!aBoolean){
                    activityMainBinding.recyclerView.smoothScrollToPosition(mainActivityViewModel.getModelsList().getValue().size()-1);
                }
            }
        });
    }

    /*Setting views*/
    private void setViews() {
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        locationsAdapter = new LocationsAdapter(mainActivityViewModel.getModelsList(),this);

            activityMainBinding.recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                    DividerItemDecoration.VERTICAL));

            activityMainBinding.recyclerView.setAdapter(locationsAdapter);
    }


    /*Creation of Dialog to add location data */
    private void addLocationThroughDialog() {
        dialog = new Dialog(MainActivity.this);
        dialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.dialog_add_location, null, false);
        dialog.setContentView(dialogBinding.getRoot());
        dialogBinding.setHandlers(myClickHandlers);
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }

    /*Handle response to check if the entered country is valid or not.*/

    @Override
    public void getWeatherReponse(WeatherResponse weatherResponse) {
        dialogBinding.btnAddLoc.setEnabled(true);

        if (weatherResponse != null && weatherResponse.getCod() == 200) {
            mainActivityViewModel.setModel(new AdapterModel(location));
            dialog.dismiss();

        } else {
            ValidationUtils.getInstance().showToast(getApplicationContext(), "Please enter valid details");
        }
    }

    @Override
    public void getWeatherForecastReponse(WeatherForecastResponse weatherForecastResponse) {

    }


    /*Handling Recycler view items click listener*/
    @Override
    public void onLocationClicked(AdapterModel model) {
        Intent in=new Intent(this, WeatherDetailsActivity.class);
                in.putExtra("Location",model.getLocation().toString());
                startActivity(in);
    }

    /* Handles all button click listeners */
    public class MyClickHandlers {
        Context context;

        MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onAddLocClicked() {
            addLocationThroughDialog();
        }

        public void onSubmitClick() {
            String loc;

            if (ValidationUtils.getInstance().isValidString(dialogBinding.edtCity.getText().toString().trim()) && ValidationUtils.getInstance().isValidString(dialogBinding.edtCountry.getText().toString()))
                loc = dialogBinding.edtCity.getText().toString().trim() + "," + dialogBinding.edtCountry.getText().toString();
            else {
                Toast.makeText(MainActivity.this, "Please Enter valid details..", Toast.LENGTH_LONG).show();
                return;
            }
            boolean bool = false;
            if(mainActivityViewModel.getModelsList()!=null&&mainActivityViewModel.getModelsList().getValue().size()>0) {
                for (int i = 0; i < mainActivityViewModel.getModelsList().getValue().size(); i++) {
                    if (((mainActivityViewModel.getModelsList().getValue().get(i)) + "").equalsIgnoreCase(loc)) {
                        ValidationUtils.getInstance().showToast(getApplicationContext(), "Location already exist");

                        bool = true;
                        break;
                    }
                }
            }

            if (!bool) {
                location = loc;

                ApiClient.getInstance().setListener(MainActivity.this);
                if (Utils.getInstance().isNetworkConnected(getApplicationContext())) {
                    ApiClient.getInstance().getWeatherDetails(location);
                    dialogBinding.btnAddLoc.setEnabled(false);
                } else {
                    ValidationUtils.getInstance().showToast(getApplicationContext(), "Please check your Network Connection");

                }

            }
        }

    }
}



