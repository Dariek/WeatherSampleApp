package by.dartec.weathesampleapp.business.main;

import by.dartec.weathesampleapp.utils.base.StringUtils;
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
        //TODO прикрутить проверку наличия данных в базе
        return rest.getAPI().getWeather(cityName, StringUtils.KEY, StringUtils.UNITS_KEY);
    }

    @Override
    public Observable<GroupResponse> getAllWeather() {
        //получаем из базы строку с id-шниками городов, используем её в запросе
        return db.getAllCitiesIds()
                .flatMap(string ->
                        rest.getAPI().getAllWeather(
                                string,
                                StringUtils.KEY,
                                StringUtils.UNITS_KEY
                        ));
    }
}
