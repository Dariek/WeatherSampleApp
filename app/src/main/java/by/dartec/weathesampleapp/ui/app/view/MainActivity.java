package by.dartec.weathesampleapp.ui.app.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.support.annotation.IdRes;
import android.app.FragmentTransaction;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.ButterKnife;
import by.dartec.weathesampleapp.R;
import by.dartec.weathesampleapp.MyApp;
import by.dartec.weathesampleapp.data.network.RestAdapter;
import by.dartec.weathesampleapp.data.network.Urls;
import by.dartec.weathesampleapp.ui.add.view.AddCityDialod;
import by.dartec.weathesampleapp.ui.main.view.MainViewFragment;
import by.dartec.weathesampleapp.ui.app.presenter.IAppPresenter;
import by.dartec.weathesampleapp.ui.details.view.DetailsFragment;
import by.dartec.weathesampleapp.utils.MyLog;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            AddCityDialod.newInstance().show(getFragmentManager(), AddCityDialod.TAG);
            Snackbar.make(view, "Add city dialog", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        });
    }

    @Override
    public void back() {
        onBackPressed();
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
//        presenter.backPressed();
    }
}