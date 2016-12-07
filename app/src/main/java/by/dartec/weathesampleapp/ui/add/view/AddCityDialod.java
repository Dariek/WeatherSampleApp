package by.dartec.weathesampleapp.ui.add.view;

import android.app.DialogFragment;
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
import by.dartec.weathesampleapp.ui.add.presenter.IACDPresenter;

/**
 * Created by root on 07.12.16.
 */

public class AddCityDialod extends DialogFragment implements IACDView {
    public static final String TAG = "AddCityDialod";
    private Unbinder butterKnife;

    @Inject
    IACDPresenter presenter;

    @NonNull
    public static AddCityDialod newInstance() {
        return new AddCityDialod();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details_fragment, container, false);
        MyApp.get().plusAddComponent().inject(this);
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
