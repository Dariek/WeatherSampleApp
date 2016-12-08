package by.dartec.weathesampleapp.data.network;

import java.util.ArrayList;

import by.dartec.weathesampleapp.data.network.models.ActualWeatherResponse;
import by.dartec.weathesampleapp.data.network.models.GroupResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by root on 07.12.16.
 */

public interface Api {

    @GET("weather")
    Observable<ActualWeatherResponse> getWeather(@Query("q") String city,
                                                 @Query("APPID") String sort,
                                                 @Query("units") String units);

    @GET("group")
    Observable<GroupResponse> getAllWeather(@Query("id") String city,
                                            @Query("APPID") String sort,
                                            @Query("units") String units);
}
