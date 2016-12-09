package by.dartec.weathesampleapp.data.network;

import by.dartec.weathesampleapp.data.network.models.forecast.ForecastWeatherResponse;
import by.dartec.weathesampleapp.data.network.models.weather.ActualWeatherResponse;
import by.dartec.weathesampleapp.data.network.models.weather.GroupResponse;
import retrofit2.http.Query;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by root on 07.12.16.
 */

public interface Api {

    @GET("weather")
    Observable<ActualWeatherResponse> getWeather(@Query("q") String cityName,
                                                 @Query("APPID") String appID,
                                                 @Query("units") String units);

    @GET("group")
    Observable<GroupResponse> getAllWeather(@Query("id") String cityID,
                                            @Query("APPID") String appID,
                                            @Query("units") String units);

    @GET("forecast")
    Observable<ForecastWeatherResponse> getWeatherForecast(@Query("id") String cityID,
                                                           @Query("APPID") String appID,
                                                           @Query("units") String units);
}
