package by.dartec.weathesampleapp.dagger.details;

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
    IDetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }
}
