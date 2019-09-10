package com.swetha.locationtask.Rest;

import com.swetha.locationtask.Model.WeatherForecastResponse;
import com.swetha.locationtask.Model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather")
    Call<WeatherResponse> getWeatherDetails(@Query("q") String loc,
                                            @Query("appid") String appid);

    @GET("forecast")
    Call<WeatherForecastResponse> getWeatherForecastDetails(@Query("q") String loc,
                                                            @Query("appid") String appid);





}