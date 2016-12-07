package by.dartec.weathesampleapp.dagger.main;

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
    IMainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
