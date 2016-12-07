package by.dartec.weathesampleapp.ui.main.presenter;

import by.dartec.weathesampleapp.ui.main.view.IMainView;

/**
 * Created by root on 07.12.16.
 */

public class MainPresenter implements IMainPresenter {
    private IMainView view;

    @Override
    public void bindView(IMainView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }
}
