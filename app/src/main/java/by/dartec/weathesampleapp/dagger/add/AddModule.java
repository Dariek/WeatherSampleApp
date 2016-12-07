package by.dartec.weathesampleapp.dagger.add;

import by.dartec.weathesampleapp.ui.add.presenter.ACDPresenter;
import by.dartec.weathesampleapp.ui.add.presenter.IACDPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 07.12.16.
 */

@Module
public class AddModule {

    @Provides
    @AddScope
    IACDPresenter provideAddCityDialogPresenter() {
        return new ACDPresenter();
    }
}
