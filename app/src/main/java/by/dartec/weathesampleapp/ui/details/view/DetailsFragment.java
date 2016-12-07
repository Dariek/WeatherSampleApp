package by.dartec.weathesampleapp.ui.details.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.dartec.weathesampleapp.MyApp;
import by.dartec.weathesampleapp.R;
import by.dartec.weathesampleapp.ui.app.presenter.IAppPresenter;
import by.dartec.weathesampleapp.ui.details.presenter.IDetailsPresenter;

/**
 * Created by root on 07.12.16.
 */

public class DetailsFragment extends Fragment implements IDetailsView {
    public static final String TAG = "DetailsFragment";

    private Unbinder butterKnife;

    @Inject
    IDetailsPresenter presenter;
    @Inject
    IAppPresenter appPresenter;

    @NonNull
    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details_fragment, container, false);
        MyApp.get().plusDetailsComponent().inject(this);
        butterKnife = ButterKnife.bind(this, rootView);
        presenter.bindView(this);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
        presenter.unbindView();
    }
}
