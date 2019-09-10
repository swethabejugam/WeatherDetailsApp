package com.swetha.locationtask;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.swetha.locationtask.Listener.WeatherResponseListener;
import com.swetha.locationtask.Model.WeatherForecastResponse;
import com.swetha.locationtask.Model.WeatherResponse;
import com.swetha.locationtask.Rest.ApiClient;
import com.swetha.locationtask.Utils.Utils;
import com.swetha.locationtask.databinding.LayoutWeatherDetailsBinding;


public class WeatherDetailsActivity extends AppCompatActivity implements WeatherResponseListener {

    private String loc;
    private WeatherDetailsBinding model;
    private LayoutWeatherDetailsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.layout_weather_details);
        model = new WeatherDetailsBinding();

        try {
            if (getIntent().getExtras() != null) {
                loc = getIntent().getExtras().get("Location").toString();
            }

            model.setLocation(loc);

            if (Utils.getInstance().isNetworkConnected(getApplicationContext())) {
                ApiClient.getInstance().getWeatherDetails(loc);
                ApiClient.getInstance().setListener(this);
                ApiClient.getInstance().getWeatherForecastDetails(loc);
            } else {
                Toast.makeText(getApplicationContext(), "Please check your Network Connection", Toast.LENGTH_LONG).show();
            }
            binding.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getWeatherReponse(WeatherResponse weatherResponse) {
        if (weatherResponse != null) {
            if (weatherResponse.getCod() == 200) {

                StringBuilder builder = new StringBuilder();
                builder.append("Temperature: ");
                builder.append(weatherResponse.getMain().getTemp());
                builder.append("\n");
                builder.append("Location: ");
                builder.append(weatherResponse.getName());
                builder.append(", ");
                builder.append(weatherResponse.getSys().getCountry());
                builder.append("\n");
                builder.append("Date: ");
                builder.append(weatherResponse.getDt());
                builder.append("\n");
                builder.append("Weather Icon: ");
                builder.append(weatherResponse.getWeather().get(0).getIcon());
                builder.append("\n");
                builder.append("Weather description: ");
                builder.append(weatherResponse.getWeather().get(0).getMain());
                builder.append("\n");
                model.setWeatherDetails(builder.toString());

            } else {
                model.setWeatherDetails(getResources().getString(R.string.err_city_not_found));
            }
            binding.invalidateAll();
        }
    }

    @Override
    public void getWeatherForecastReponse(WeatherForecastResponse weatherForecastResponse) {

        if (weatherForecastResponse != null) {
            if (weatherForecastResponse.getCod().equalsIgnoreCase("200")) {
//                for(int i=0;i<weatherForecastResponse.getList().size();i++){
//                    int reqDt=1566283914;
//                    System.out.println("weatherForecastResponse.getList():"+weatherForecastResponse.getList().get(i).getDt()+"--"+reqDt);
//                    if(((weatherForecastResponse.getList().get(i).getDt())==reqDt)){

//                        StringBuilder builder = new StringBuilder();
//                        builder.append("Temperature:" + weatherForecastResponse.getList().get().getMain().getTemp()+"\n");
//                        builder.append("Time only :" + weatherForecastResponse.getList().get(i).getDt()+"\n");
//                        builder.append("Weather Icon :" + weatherForecastResponse.getList().get(i).getWeather().get(0).getIcon()+"\n");
//                        builder.append("Weather description:" + weatherForecastResponse.getList().get(i).getWeather().get(0).getMain()+"\n");
//                        tvWeatherforecastDetails.setText(builder);
//                        break;
//                    }
//                }
                /////
                StringBuilder builder1 = new StringBuilder();
                builder1.append("Temperature: ");
                builder1.append(weatherForecastResponse.getList().get(0).getMain().getTemp());
                builder1.append("\n");
                builder1.append("Time only: ");
                builder1.append(weatherForecastResponse.getList().get(0).getDt());
                builder1.append("\n");
                builder1.append("Weather Icon: ");
                builder1.append(weatherForecastResponse.getList().get(0).getWeather().get(0).getIcon());
                builder1.append("\n");
                builder1.append("Weather description: ");
                builder1.append(weatherForecastResponse.getList().get(0).getWeather().get(0).getMain());
                builder1.append("\n");
                model.setWeatherForecastDetails(builder1.toString());
            } else {
                model.setWeatherForecastDetails(weatherForecastResponse.getMessage().toString());
            }
            binding.invalidateAll();
        }

    }
}
