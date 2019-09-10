package com.swetha.locationtask.Rest;

import android.util.Log;
import com.swetha.locationtask.Constants.AppConstants;
import com.swetha.locationtask.Listener.WeatherResponseListener;
import com.swetha.locationtask.Model.WeatherForecastResponse;
import com.swetha.locationtask.Model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit retrofit = null;
    private static ApiClient instance = null;
    public WeatherResponseListener weatherResponseListener;

    public static ApiClient getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new ApiClient() : instance;
            }
        }
        return instance;
    }

    private ApiClient() {

    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public void setListener(WeatherResponseListener weatherResponseListener) {
        this.weatherResponseListener = weatherResponseListener;
    }
    public WeatherResponse[] getWeatherDetails(String location) {
        final WeatherResponse[] currentResponse = new WeatherResponse[1];
        ApiInterface apiService =
                getClient().create(ApiInterface.class);

        Call<WeatherResponse> call = apiService.getWeatherDetails(location, AppConstants.API_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
//                List<Movie> movies = response.body().getResults();
                currentResponse[0] =response.body();
                weatherResponseListener.getWeatherReponse(currentResponse[0]);
                Log.e("apiclient weather ", response+"--+"+response.code());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e("apiclient", t.toString());
            }
        });
        return currentResponse;
    }
        public WeatherForecastResponse[] getWeatherForecastDetails(String location){
            ApiInterface apiService =
                    getClient().create(ApiInterface.class);
            final WeatherForecastResponse[] currentResponse = new WeatherForecastResponse[1];
            Call<WeatherForecastResponse> call = apiService.getWeatherForecastDetails(location, AppConstants.API_KEY);
            call.enqueue(new Callback<WeatherForecastResponse>() {
                @Override
                public void onResponse(Call<WeatherForecastResponse> call, Response<WeatherForecastResponse> response) {
                        currentResponse[0] =response.body();
                        weatherResponseListener.getWeatherForecastReponse(currentResponse[0]);
                    Log.e("weather forecast ", response+"--+"+response.code());
                }

                @Override
                public void onFailure(Call<WeatherForecastResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e("apiclient", t.toString());
                }
            });
    return currentResponse;
    }
    }
