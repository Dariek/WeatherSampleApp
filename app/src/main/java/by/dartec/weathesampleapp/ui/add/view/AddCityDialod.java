package by.dartec.weathesampleapp.ui.add.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import by.dartec.weathesampleapp.ui.add.presenter.IACDPresenter;
import by.dartec.weathesampleapp.MyApp;
import by.dartec.weathesampleapp.R;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by root on 07.12.16.
 */

public class AddCityDialod extends DialogFragment implements IACDView {
    public static final String TAG = "AddCityDialod";

    private Unbinder butterKnife;

    @BindView(R.id.edCityName)
    EditText edCityName;

    @Inject
    IACDPresenter presenter;

    @NonNull
    public static AddCityDialod newInstance() {
        return new AddCityDialod();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_dialog, container, false);
        MyApp.get().plusAddComponent().inject(this);
        butterKnife = ButterKnife.bind(this, rootView);
        presenter.bindView(this);

        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.empty);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
        presenter.unbindView();
        MyApp.get().clearAddComponent();
    }

    @OnClick(R.id.btnCancel)
    void close() {
        dismiss();
    }

    @OnClick(R.id.btnAdd)
    void ckeck() {
        presenter.addCity(edCityName.getText().toString());
    }

    @Override
    public void updateUI(State state) {
        switch (state) {
            case CITY_ERROR:
                break;
            case NET_ERROR:
                break;
            case SUCCESS:
                dismiss();
                break;
        }
    }
}
