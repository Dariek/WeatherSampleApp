package by.dartec.weathesampleapp.ui.main.presenter;

import java.util.ArrayList;

import by.dartec.weathesampleapp.business.main.IMainInteractor;
import by.dartec.weathesampleapp.data.network.models.weather.ActualWeatherResponse;
import by.dartec.weathesampleapp.data.network.models.weather.GroupResponse;
import by.dartec.weathesampleapp.ui.main.view.IMainView;
import by.dartec.weathesampleapp.utils.MyLog;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by root on 07.12.16.
 */

public class MainPresenter implements IMainPresenter {
    private IMainInteractor interactor;
    private Subscription subscription;
    private GroupResponse response;
    private IMainView view;

    public MainPresenter(IMainInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onItemClick(int position) {
        ArrayList<ActualWeatherResponse> buf = response.getList();
        if(buf.size() > position) {
            view.onItemClick(buf.get(position).getId());
        }
    }

    @Override
    public void getWeather() {
        view.showProgress();
        subscription = interactor.getAllWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        resp -> {
                            view.hideProgress();
                            view.updateAllWeather(resp.getList());
                            response = resp;
                        }, t -> {
                            view.loadingError();
                            MyLog.errLog(t.getMessage());
                        });
    }

    @Override
    public void updateWeather(String city, int pos) {
        subscription = interactor.getWeather(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resp -> {
                    MyLog.myLog(resp.toString());
                }, t -> {
                    MyLog.errLog(t.getMessage());
                });
    }

    @Override
    public void bindView(IMainView view) {
        this.view = view;
        getWeather();
    }

    @Override
    public void unbindView() {
        subscription.unsubscribe();
        view = null;
    }
}
