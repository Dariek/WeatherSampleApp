package by.dartec.weathesampleapp.ui.main.view;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.dartec.weathesampleapp.MyApp;
import by.dartec.weathesampleapp.R;
import by.dartec.weathesampleapp.data.network.models.weather.ActualWeatherResponse;
import by.dartec.weathesampleapp.ui.app.presenter.IAppPresenter;
import by.dartec.weathesampleapp.ui.details.view.DetailsFragment;
import by.dartec.weathesampleapp.ui.main.adapters.ActualWeatherAdapter;
import by.dartec.weathesampleapp.ui.main.presenter.IMainPresenter;
import by.dartec.weathesampleapp.utils.MyLog;

/**
 * Created by root on 07.12.16.
 */

public class MainViewFragment extends Fragment implements IMainView {
    public static final String TAG = "MainViewFragment";

    private ArrayList<ActualWeatherResponse> items;

    private Unbinder butterKnife;
    @BindView(R.id.recWeather)
    RecyclerView recWeather;

    @BindView(R.id.prBar)
    ProgressBar prBar;

    @Inject
    IMainPresenter presenter;
    @Inject
    ActualWeatherAdapter adapter;
    @Inject
    IAppPresenter appPresenter;

    @NonNull
    public static MainViewFragment newInstance() {
        return new MainViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        MyApp.get().plusMainComponent().inject(this);
        butterKnife = ButterKnife.bind(this, rootView);
        presenter.bindView(this);

        adapter.setOnItemClickListener((view, position) -> presenter.onItemClick(position));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recWeather.setLayoutManager(linearLayoutManager);

        appPresenter.hideArrow();
        getActivity().findViewById(R.id.imgUpdate).setOnClickListener(view -> presenter.getWeather());

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
        presenter.unbindView();
        MyApp.get().clearMainComponent();
    }

    @Override
    public void showProgress() {
        adapter.clean();
        prBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        prBar.setVisibility(View.GONE);
    }

    @Override
    public void loadingError() {
        prBar.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(String id) {
        appPresenter.replaceByTag(DetailsFragment.TAG, id);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void updateAllWeather(ArrayList<ActualWeatherResponse> resp) {
        items = resp;
        adapter.setData(items);
        recWeather.setAdapter(adapter);
    }

    @Override
    public void updateWeatherByPosition(ActualWeatherResponse resp, int position) {
        if (items != null) {
            items.remove(position);
            items.add(position, resp);
            adapter.notifyDataSetChanged();
        }
    }
}
