package by.dartec.weathesampleapp.ui.add.presenter;

import by.dartec.weathesampleapp.ui.add.view.IACDView;

/**
 * Created by root on 07.12.16.
 */

public class ACDPresenter implements IACDPresenter {
    private IACDView view;

    @Override
    public void bindView(IACDView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }
}
