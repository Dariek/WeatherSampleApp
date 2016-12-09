package by.dartec.weathesampleapp.ui.main.view;

import java.util.ArrayList;

import by.dartec.weathesampleapp.data.network.models.weather.ActualWeatherResponse;
import by.dartec.weathesampleapp.utils.base.ILoadingState;

/**
 * Created by root on 07.12.16.
 */

public interface IMainView extends ILoadingState{

    void onItemClick(String id);
    void updateAllWeather(ArrayList<ActualWeatherResponse> resp);
    void updateWeatherByPosition(ActualWeatherResponse resp, int position);
}
