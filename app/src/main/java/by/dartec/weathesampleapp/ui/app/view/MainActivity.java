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
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        });

//        rest.getAPI().getAllWeather(//new String[]{"524901","703448","2643743"}
//                Urls.KEY, Urls.UNITS_KEY,
//             //   new String[]{"524901","703448","2643743"})
//                "524901,703448,2643743,")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(resp -> {
//                    MyLog.myLog("size: " + resp.getList().size() + ";\n" + resp.getList().get(0).toString());
//                }, t -> {
//                    MyLog.errLog(t.getMessage());
//                });
//        ArrayList<String> m = new ArrayList<String>(){{
//            add("524901");
//            add("703448");
//            add("2643743");
//        }};
//        StringBuilder builder = new StringBuilder();
//        for(String s : m){
//            builder.append(s);
//            builder.append(',');
//        }
//        MyLog.myLog(builder.toString());
    }

    @Override
    public void replaceByTag(String TAG) {
        txtTitle.setText(TAG);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (TAG) {
            case MainViewFragment.TAG:
                transaction.replace(id, MainViewFragment.newInstance(), MainViewFragment.TAG);
                break;
            case DetailsFragment.TAG:
                transaction.replace(id, DetailsFragment.newInstance(), DetailsFragment.TAG);
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
//        super.onBackPressed();
        presenter.backPressed();
    }
}