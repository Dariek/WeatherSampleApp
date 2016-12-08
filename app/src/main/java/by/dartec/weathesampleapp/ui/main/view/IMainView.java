package by.dartec.weathesampleapp.ui.main.view;

import java.util.ArrayList;

import by.dartec.weathesampleapp.data.network.models.ActualWeatherResponse;

/**
 * Created by root on 07.12.16.
 */

public interface IMainView {
    void showProgress();
    void hideProgress();
    void loadingError();

    void updateAllWeather(ArrayList<ActualWeatherResponse> resp);
    void updateWeatherByPosition(ActualWeatherResponse resp, int position);
}
