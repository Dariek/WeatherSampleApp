package by.dartec.weathesampleapp.ui.app.presenter;

import by.dartec.weathesampleapp.ui.app.view.IAppView;

/**
 * Created by root on 07.12.16.
 */

public interface IAppPresenter {
    void showArrow();
    void hideArrow();

    void replaceByTag(String... str);

    void bindView(IAppView view);
    void unbindView();
}
