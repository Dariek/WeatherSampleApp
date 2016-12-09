package by.dartec.weathesampleapp.ui.details.view;

import by.dartec.weathesampleapp.data.network.models.forecast.ForecastWeatherResponse;
import by.dartec.weathesampleapp.utils.base.ILoadingState;

/**
 * Created by root on 07.12.16.
 */

public interface IDetailsView extends ILoadingState {
    String getID();
    void updateUI(ForecastWeatherResponse response);
}
