package by.dartec.weathesampleapp.data.network;

import by.dartec.weathesampleapp.data.network.models.ActualWeatherResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by root on 07.12.16.
 */

public interface Api {

    @GET("weather")
    Observable<ActualWeatherResponse> getWeather(@Query("city") String city, @Query("APPID") String sort);
}
