package by.dartec.weathesampleapp.dagger.details;

import android.content.Context;

import java.util.Collection;
import java.util.Collections;

import by.dartec.weathesampleapp.business.details.DetailsInteractor;
import by.dartec.weathesampleapp.business.details.IDetailsInteractor;
import by.dartec.weathesampleapp.data.network.RestAdapter;
import by.dartec.weathesampleapp.data.repositories.db.IDBRepository;
import by.dartec.weathesampleapp.ui.details.adapters.ForecastWeatherAdapter;
import by.dartec.weathesampleapp.ui.details.presenter.DetailsPresenter;
import by.dartec.weathesampleapp.ui.details.presenter.IDetailsPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 07.12.16.
 */

@Module
public class DetailsModule {

    @Provides
    @DetailsScope
    IDetailsPresenter provideDetailsPresenter(IDetailsInteractor interactor) {
        return new DetailsPresenter(interactor);
    }

    @Provides
    @DetailsScope
    ForecastWeatherAdapter provideForecastAdapter(Context context) {
        return new ForecastWeatherAdapter(context, Collections.emptyList());
    }

    @Provides
    @DetailsScope
    IDetailsInteractor provideDetailsInteractor(RestAdapter rest, IDBRepository db) {
        return new DetailsInteractor(rest, db);
    }
}
