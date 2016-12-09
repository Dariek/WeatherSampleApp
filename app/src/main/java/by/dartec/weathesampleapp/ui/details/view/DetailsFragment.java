package by.dartec.weathesampleapp.ui.details.view;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.ButterKnife;
import by.dartec.weathesampleapp.R;
import by.dartec.weathesampleapp.MyApp;
import by.dartec.weathesampleapp.ui.app.presenter.IAppPresenter;
import by.dartec.weathesampleapp.data.network.models.forecast.ForecastWeatherResponse;
import by.dartec.weathesampleapp.ui.details.adapters.ForecastWeatherAdapter;
import by.dartec.weathesampleapp.ui.details.presenter.IDetailsPresenter;

/**
 * Created by root on 07.12.16.
 */

public class DetailsFragment extends Fragment implements IDetailsView {
    public static final String TAG = "DetailsFragment";
    private static final String key = "id";

    private Unbinder butterKnife;
    @BindView(R.id.recWeather)
    RecyclerView recWeather;

    @BindView(R.id.prBar)
    ProgressBar prBar;

    @BindView(R.id.txtCity)
    TextView txtCity;

    @Inject
    IDetailsPresenter presenter;
    @Inject
    IAppPresenter appPresenter;
    @Inject
    ForecastWeatherAdapter adapter;

    @NonNull
    public static DetailsFragment newInstance(String id) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle arg = new Bundle();
        arg.putString(key, id);
        fragment.setArguments(arg);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details_fragment, container, false);
        MyApp.get().plusDetailsComponent().inject(this);
        butterKnife = ButterKnife.bind(this, rootView);
        presenter.bindView(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recWeather.setLayoutManager(linearLayoutManager);
        recWeather.setAdapter(adapter);
        adapter.clean();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
        presenter.unbindView();
        MyApp.get().clearDetailsComponent();
    }

    @Override
    public String getID() {
        String id = null;
        Bundle arg = getArguments();
        if(arg != null) id = arg.getString(key);
        return id != null ? id : "0";
    }

    @Override
    public void updateUI(ForecastWeatherResponse response) {
        adapter.setData(response);
        txtCity.setText(response.getCity().getName());
    }

    @Override
    public void showProgress() {
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
}
