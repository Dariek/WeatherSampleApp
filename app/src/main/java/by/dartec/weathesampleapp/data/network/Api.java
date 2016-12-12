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

    /**
     * Получение погоды по названию города (+ возвращает id города)
     *
     * @param cityName
     * @param appID
     * @param units
     * @return
     */
    @GET("weather")
    Observable<ActualWeatherResponse> getWeather(@Query("q") String cityName,
                                                 @Query("APPID") String appID,
                                                 @Query("units") String units);

    /**
     * Получение погоды по id города
     *
     * @param cityID
     * @param appID
     * @param units
     * @return
     */
    @GET("group")
    Observable<GroupResponse> getAllWeather(@Query("id") String cityID,
                                            @Query("APPID") String appID,
                                            @Query("units") String units);

    /**
     * Получение прогноза по id города
     *
     * @param cityID
     * @param appID
     * @param units
     * @return
     */
    @GET("forecast")
    Observable<ForecastWeatherResponse> getWeatherForecast(@Query("id") String cityID,
                                                           @Query("APPID") String appID,
                                                           @Query("units") String units);
}
