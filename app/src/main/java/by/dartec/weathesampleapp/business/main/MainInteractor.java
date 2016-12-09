package by.dartec.weathesampleapp.business.main;

import by.dartec.weathesampleapp.data.network.Urls;
import by.dartec.weathesampleapp.data.network.RestAdapter;
import by.dartec.weathesampleapp.data.network.models.weather.GroupResponse;
import by.dartec.weathesampleapp.data.repositories.db.IDBRepository;
import by.dartec.weathesampleapp.data.network.models.weather.ActualWeatherResponse;
import rx.Observable;

/**
 * Created by root on 08.12.16.
 */

public class MainInteractor implements IMainInteractor {
    private RestAdapter rest;
    private IDBRepository db;

    public MainInteractor(RestAdapter rest, IDBRepository db) {
        this.rest = rest;
        this.db = db;
    }

    @Override
    public Observable<ActualWeatherResponse> getWeather(String cityName) {
        //TODO можно прикрутить проверка наличия данных в базе
        return rest.getAPI().getWeather(cityName, Urls.KEY, Urls.UNITS_KEY);
    }

    @Override
    public Observable<GroupResponse> getAllWeather() {
        return db.getAllCitiesIds()
                .flatMap(string ->
                        rest.getAPI().getAllWeather(
                                string,
                                Urls.KEY,
                                Urls.UNITS_KEY
                        ));
    }
}
