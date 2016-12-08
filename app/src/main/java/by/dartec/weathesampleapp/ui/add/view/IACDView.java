package by.dartec.weathesampleapp.ui.add.view;

/**
 * Created by root on 07.12.16.
 */

public interface IACDView {
    enum State {NET_ERROR, CITY_ERROR, SUCCESS}

    void updateUI(State state);
}
