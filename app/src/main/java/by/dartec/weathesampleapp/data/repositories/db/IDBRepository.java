package by.dartec.weathesampleapp.data.repositories.db;

import java.util.ArrayList;

import rx.Observable;
import rx.Single;

/**
 * Created by root on 08.12.16.
 */

public interface IDBRepository {
    Observable<String> getAllCitiesIds();
}
