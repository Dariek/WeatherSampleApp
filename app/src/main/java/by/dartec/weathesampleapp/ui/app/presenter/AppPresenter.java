package by.dartec.weathesampleapp.ui.app.presenter;

import by.dartec.weathesampleapp.ui.app.view.IAppView;
import by.dartec.weathesampleapp.ui.main.view.MainViewFragment;

/**
 * Created by root on 07.12.16.
 */

public class AppPresenter implements IAppPresenter {
    private IAppView view;

    public AppPresenter() {
    }

    @Override
    public void addCityClick() {
        view.showDialog();
    }

    @Override
    public void showArrow() {
        view.showArrow();
    }

    @Override
    public void hideArrow() {
        view.hideArrow();
    }

    @Override
    public void replaceByTag(String... str) {
        view.replaceByTag(str);
    }

    @Override
    public void bindView(IAppView view) {
        this.view = view;

        //избавляем View от принятия решений об отображении каких либо данных
        this.view.replaceByTag(MainViewFragment.TAG);
    }

    @Override
    public void unbindView() {
        view = null;
    }
}
