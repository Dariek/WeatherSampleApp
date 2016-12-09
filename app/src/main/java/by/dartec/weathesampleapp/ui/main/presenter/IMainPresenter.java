package by.dartec.weathesampleapp.ui.main.presenter;

import by.dartec.weathesampleapp.ui.main.view.IMainView;

/**
 * Created by root on 07.12.16.
 */

public interface IMainPresenter {
    void onItemClick(int position);

    void getWeather();

    void bindView(IMainView view);
    void unbindView();
}
