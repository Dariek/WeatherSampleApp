package by.dartec.weathesampleapp.ui.details.presenter;

import by.dartec.weathesampleapp.ui.details.view.IDetailsView;

/**
 * Created by root on 07.12.16.
 */

public class DetailsPresenter implements IDetailsPresenter {
    private IDetailsView view;

    @Override
    public void bindView(IDetailsView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }
}
