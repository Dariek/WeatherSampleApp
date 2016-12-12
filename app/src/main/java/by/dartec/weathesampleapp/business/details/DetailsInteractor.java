package by.dartec.weathesampleapp.business.details;

import rx.Observable;
import by.dartec.weathesampleapp.utils.base.StringUtils;
import by.dartec.weathesampleapp.data.network.RestAdapter;
import by.dartec.weathesampleapp.data.repositories.db.IDBRepository;
import by.dartec.weathesampleapp.data.network.models.forecast.ForecastWeatherResponse;

/**
 * Created by root on 09.12.16.
 */

public class DetailsInteractor implements IDetailsInteractor {
    private RestAdapter rest;
    private IDBRepository db;

    public DetailsInteractor(RestAdapter rest, IDBRepository db) {
        this.rest = rest;
        this.db = db;
    }

    @Override
    public Observable<ForecastWeatherResponse> getWeatherForecast(String id) {
        //TODO тянем данные из базы, если нет или устарели, подгружаем
        return db.getOldForecastByID(id)
                .flatMap(response -> isDataFresh(response)
                        ? Observable.fromCallable(() -> response)
                        : rest.getAPI().getWeatherForecast(id, StringUtils.KEY, StringUtils.UNITS_KEY));
    }

    private boolean isDataFresh(ForecastWeatherResponse response) {
        return false;
    }
}
