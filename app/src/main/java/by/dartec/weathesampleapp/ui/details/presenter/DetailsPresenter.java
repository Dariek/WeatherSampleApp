package by.dartec.weathesampleapp.ui.details.presenter;

import by.dartec.weathesampleapp.business.details.IDetailsInteractor;
import by.dartec.weathesampleapp.ui.details.view.IDetailsView;
import rx.android.schedulers.AndroidSchedulers;
import by.dartec.weathesampleapp.utils.MyLog;
import rx.schedulers.Schedulers;
import rx.Subscription;

/**
 * Created by root on 07.12.16.
 */

public class DetailsPresenter implements IDetailsPresenter {
    private IDetailsView view;
    private IDetailsInteractor interactor;
    private Subscription subscription;

    public DetailsPresenter(IDetailsInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void bindView(IDetailsView view) {
        this.view = view;
        load();
    }

    @Override
    public void unbindView() {
        subscription.unsubscribe();
        view = null;
    }

    @Override
    public void load() {
        view.showProgress();
        subscription = interactor.getWeatherForecast(view.getID())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    view.hideProgress();
                    view.updateUI(response);
                }, t -> {
                    MyLog.errLog(t.getMessage());
                    view.loadingError();
                });
    }
}
