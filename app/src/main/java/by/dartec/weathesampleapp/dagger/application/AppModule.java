package by.dartec.weathesampleapp.dagger.application;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import by.dartec.weathesampleapp.data.network.RestAdapter;
import by.dartec.weathesampleapp.data.repositories.db.DBRepository;
import by.dartec.weathesampleapp.data.repositories.db.IDBRepository;
import by.dartec.weathesampleapp.ui.app.presenter.AppPresenter;
import by.dartec.weathesampleapp.ui.app.presenter.IAppPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 07.12.16.
 */

@Module
public class AppModule {
    private final Context ct;

    public AppModule(@NonNull Context context) {
        ct = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return ct;
    }

    @Provides
    @Singleton
    IAppPresenter provideMainAppPresenter() {
        return new AppPresenter();
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter() {
        return new RestAdapter();
    }

    @Provides
    @Singleton
    IDBRepository provideDBRepository() {
        return new DBRepository();
    }
}
