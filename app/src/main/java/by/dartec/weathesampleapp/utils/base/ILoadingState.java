package by.dartec.weathesampleapp.utils.base;

/**
 * Created by root on 09.12.16.
 */

public interface ILoadingState {
    void showProgress();
    void hideProgress();
    void loadingError();
}
