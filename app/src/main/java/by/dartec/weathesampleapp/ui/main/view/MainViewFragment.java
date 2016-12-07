package by.dartec.weathesampleapp.ui.main.view;

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
import by.dartec.weathesampleapp.ui.main.presenter.IMainPresenter;

/**
 * Created by root on 07.12.16.
 */

public class MainViewFragment extends Fragment implements IMainView {
    public static final String TAG = "MainViewFragment";
    private Unbinder butterKnife;

    @Inject
    IMainPresenter presenter;

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

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
        presenter.unbindView();
    }
}
