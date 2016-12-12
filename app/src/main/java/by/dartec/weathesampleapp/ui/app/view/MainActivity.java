package by.dartec.weathesampleapp.ui.app.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.IdRes;
import android.app.FragmentTransaction;
import android.widget.TextView;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.ButterKnife;
import by.dartec.weathesampleapp.R;
import by.dartec.weathesampleapp.MyApp;
import by.dartec.weathesampleapp.data.network.RestAdapter;
import by.dartec.weathesampleapp.ui.add.view.AddCityDialod;
import by.dartec.weathesampleapp.ui.main.view.MainViewFragment;
import by.dartec.weathesampleapp.ui.app.presenter.IAppPresenter;
import by.dartec.weathesampleapp.ui.details.view.DetailsFragment;

import static by.dartec.weathesampleapp.R.id.blanck;

public class MainActivity extends AppCompatActivity implements IAppView {
    @IdRes
    private static final int id = blanck;

    private Unbinder butterKnife;
    @BindView(R.id.txtTitle)
    TextView txtTitle;

    @Inject
    IAppPresenter presenter;

    @Inject
    RestAdapter rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApp.get().getComponent().inject(this);
        butterKnife = ButterKnife.bind(this);
        presenter.bindView(this);
    }

    @OnClick(R.id.fab)
    public void addCityClick() {
        presenter.addCityClick();
    }

    @Override
    public void showDialog() {
        AddCityDialod.newInstance().show(getFragmentManager(), AddCityDialod.TAG);
    }

    @Override
    public void showArrow() {
        txtTitle.setText(getString(R.string.screen_title_details));
        txtTitle.setCompoundDrawablesWithIntrinsicBounds(
                ContextCompat.getDrawable(this, R.drawable.back), null, null, null);
        txtTitle.setOnClickListener(view -> onBackPressed());
    }

    @Override
    public void hideArrow() {
        txtTitle.setText(getString(R.string.screen_title_main));
        txtTitle.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        txtTitle.setOnClickListener(null);
    }

    @Override
    public void replaceByTag(String... str) {
        String TAG = str[0];
        txtTitle.setText(TAG);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (TAG) {
            case MainViewFragment.TAG:
                transaction.replace(id, MainViewFragment.newInstance(), MainViewFragment.TAG);
                break;
            case DetailsFragment.TAG:
                transaction.replace(id, DetailsFragment.newInstance(str[1]), DetailsFragment.TAG)
                        .addToBackStack(TAG);
                break;
            default:
                transaction.replace(id, MainViewFragment.newInstance(), MainViewFragment.TAG);
                break;
        }
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        butterKnife.unbind();
        presenter.unbindView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}