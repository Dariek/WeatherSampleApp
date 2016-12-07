package by.dartec.weathesampleapp.ui.app.presenter;

import by.dartec.weathesampleapp.ui.app.view.IAppView;

/**
 * Created by root on 07.12.16.
 */

public interface IAppPresenter {
    void backPressed();
    void replaceByTag(String TAG);

    void bindView(IAppView view);
    void unbindView();
}
