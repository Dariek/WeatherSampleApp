package by.dartec.weathesampleapp.ui.details.presenter;

import by.dartec.weathesampleapp.ui.details.view.IDetailsView;

/**
 * Created by root on 07.12.16.
 */

public interface IDetailsPresenter {
    void load();
    void bindView(IDetailsView view);
    void unbindView();
}
