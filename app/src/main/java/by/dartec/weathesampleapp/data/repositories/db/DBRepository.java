package by.dartec.weathesampleapp.data.repositories.db;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import by.dartec.weathesampleapp.data.network.models.forecast.ForecastWeatherResponse;
import rx.Observable;

/**
 * Created by root on 08.12.16.
 */

public class DBRepository implements IDBRepository {

    //Эмитация получения данных из базы
    @Override
    public Observable<String> getAllCitiesIds() {
        return Observable.timer(1, TimeUnit.SECONDS)
                .flatMap(aLong ->
                        Observable.fromCallable(() ->
                                convertToString(getCityIDs())
                        ));
    }

    //Эмитация получения данных из базы
    @Override
    public Observable<ForecastWeatherResponse> getOldForecastByID(String id) {
        return Observable.timer(1, TimeUnit.SECONDS)
                .flatMap(aLong ->
                        Observable.fromCallable(this::getOldForecast));
    }

    //Формирование строки с id-шниками городов
    private String convertToString(ArrayList<String> items) {
        StringBuilder builder = new StringBuilder();
        for(String s : items){
            builder.append(s);
            builder.append(',');
        }
        return builder.toString();
    }

    //Эмитация получения данных из базы
    private ArrayList<String> getCityIDs() {
        return new ArrayList<String>(){{
            add("524901");
            add("703448");
            add("2643743");
        }};
    }

    private ForecastWeatherResponse getOldForecast() {
        return new ForecastWeatherResponse();
    }
}
