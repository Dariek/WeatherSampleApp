package by.dartec.weathesampleapp.business.main;

import by.dartec.weathesampleapp.data.network.models.weather.ActualWeatherResponse;
import by.dartec.weathesampleapp.data.network.models.weather.GroupResponse;
import rx.Observable;

/**
 * Created by root on 08.12.16.
 */

public interface IMainInteractor {
    Observable<ActualWeatherResponse> getWeather(String cityName);
    Observable<GroupResponse> getAllWeather();
}
