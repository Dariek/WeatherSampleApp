package by.dartec.weathesampleapp.ui.add.presenter;

import by.dartec.weathesampleapp.ui.add.view.IACDView;
import by.dartec.weathesampleapp.business.add.IACDInteractor;

import static by.dartec.weathesampleapp.ui.add.view.IACDView.State.*;

/**
 * Created by root on 07.12.16.
 */

public class ACDPresenter implements IACDPresenter {
    private IACDInteractor interactor;
    private IACDView view;

    public ACDPresenter(IACDInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void addCity(String name) {
        if(interactor.ckeckNet()) {
            view.updateUI(NET_ERROR);
        } else if(!interactor.isValideCityName(name)) {
            view.updateUI(CITY_ERROR);
        } else {
            view.updateUI(SUCCESS);
        }
    }

    @Override
    public void bindView(IACDView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }
}
