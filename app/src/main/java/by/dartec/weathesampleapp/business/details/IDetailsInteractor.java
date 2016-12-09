package by.dartec.weathesampleapp.business.details;

import by.dartec.weathesampleapp.data.network.models.forecast.ForecastWeatherResponse;
import rx.Observable;

/**
 * Created by root on 09.12.16.
 */

public interface IDetailsInteractor {
    Observable<ForecastWeatherResponse> getWeatherForecast(String id);
}
