package by.dartec.weathesampleapp.data.repositories.db;

import by.dartec.weathesampleapp.data.network.models.forecast.ForecastWeatherResponse;
import rx.Observable;

/**
 * Created by root on 08.12.16.
 */

public interface IDBRepository {
    Observable<String> getAllCitiesIds();

    Observable<ForecastWeatherResponse> getOldForecastByID(String id);

}
