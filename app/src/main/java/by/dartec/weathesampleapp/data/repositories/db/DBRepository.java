package by.dartec.weathesampleapp.data.repositories.db;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by root on 08.12.16.
 */

public class DBRepository implements IDBRepository {

    @Override
    public Observable<String> getAllCitiesIds() {
        return Observable.timer(0, TimeUnit.SECONDS)
                .flatMap(aLong ->
                        Observable.fromCallable(() ->
                                convertToString(
                                        new ArrayList<String>(){{
                                            add("524901");
                                            add("703448");
                                            add("2643743");
                                        }})
                        ));
    }

    private String convertToString(ArrayList<String> items) {
        StringBuilder builder = new StringBuilder();
        for(String s : items){
            builder.append(s);
            builder.append(',');
        }
        return builder.toString();
    }
}
