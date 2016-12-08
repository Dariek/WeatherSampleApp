package by.dartec.weathesampleapp.ui.main.presenter;

import by.dartec.weathesampleapp.ui.main.view.IMainView;

/**
 * Created by root on 07.12.16.
 */

public interface IMainPresenter {
    void getWeather();
    void updateWeather(String city, int pos);

    void bindView(IMainView view);
    void unbindView();
}
