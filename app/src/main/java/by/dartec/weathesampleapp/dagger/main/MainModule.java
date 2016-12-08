package by.dartec.weathesampleapp.dagger.main;

import android.content.Context;

import by.dartec.weathesampleapp.business.main.IMainInteractor;
import by.dartec.weathesampleapp.business.main.MainInteractor;
import by.dartec.weathesampleapp.data.network.RestAdapter;
import by.dartec.weathesampleapp.data.repositories.db.IDBRepository;
import by.dartec.weathesampleapp.ui.main.adapters.ActualWeatherAdapter;
import by.dartec.weathesampleapp.ui.main.presenter.IMainPresenter;
import by.dartec.weathesampleapp.ui.main.presenter.MainPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 07.12.16.
 */

@Module
public class MainModule {

    @Provides
    @MainScope
    IMainPresenter provideMainPresenter(IMainInteractor interactor) {
        return new MainPresenter(interactor);
    }

    @Provides
    @MainScope
    ActualWeatherAdapter provideWeatherAdapter(Context context) {
        return new ActualWeatherAdapter(context);
    }

    @Provides
    @MainScope
    IMainInteractor provideMainInteractor(RestAdapter rest, IDBRepository idbRepository) {
        return new MainInteractor(rest, idbRepository);
    }
}
