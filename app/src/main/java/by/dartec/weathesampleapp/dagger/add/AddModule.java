package by.dartec.weathesampleapp.dagger.add;

import by.dartec.weathesampleapp.ui.add.presenter.IACDPresenter;
import by.dartec.weathesampleapp.ui.add.presenter.ACDPresenter;
import by.dartec.weathesampleapp.business.add.IACDInteractor;
import by.dartec.weathesampleapp.business.add.ACDInteractor;

import dagger.Provides;
import dagger.Module;

/**
 * Created by root on 07.12.16.
 */

@Module
public class AddModule {

    @Provides
    @AddScope
    IACDPresenter provideAddCityDialogPresenter(IACDInteractor interactor) {
        return new ACDPresenter(interactor);
    }

    @Provides
    @AddScope
    IACDInteractor provideAddCityDialogInteractor() {
        return new ACDInteractor();
    }
}
