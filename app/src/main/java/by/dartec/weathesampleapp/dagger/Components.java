package by.dartec.weathesampleapp.dagger;

import android.content.Context;
import android.support.annotation.NonNull;

import by.dartec.weathesampleapp.dagger.add.AddComponent;
import by.dartec.weathesampleapp.dagger.add.AddModule;
import by.dartec.weathesampleapp.dagger.application.AppComponent;
import by.dartec.weathesampleapp.dagger.application.AppModule;
import by.dartec.weathesampleapp.dagger.application.DaggerAppComponent;
import by.dartec.weathesampleapp.dagger.details.DetailsComponent;
import by.dartec.weathesampleapp.dagger.details.DetailsModule;
import by.dartec.weathesampleapp.dagger.main.MainComponent;
import by.dartec.weathesampleapp.dagger.main.MainModule;

/**
 * Created by root on 07.12.16.
 */

public class Components {
    private AppComponent component;
    private AddComponent addComponent;
    private MainComponent mainComponent;
    private DetailsComponent detailsComponent;

    private Components(Context context) {
        component = prepare(context);
    }

    protected AppComponent prepare (Context context) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(context))
                .build();
    }

    @NonNull
    public static Components build(Context context) {
        return new Components(context);
    }

    public AppComponent getComponent() {
        return component;
    }

    public MainComponent plusMainComponent() {
        if (mainComponent == null) {
            mainComponent = component.plus(new MainModule());
        }
        return mainComponent;
    }

    public AddComponent plusAddComponent() {
        if (addComponent == null) {
            addComponent = component.plus(new AddModule());
        }
        return addComponent;
    }

    public DetailsComponent plusDetailsComponent() {
        if (detailsComponent == null) {
            detailsComponent = component.plus(new DetailsModule());
        }
        return detailsComponent;
    }

    public void clearMainComponent() {
        mainComponent = null;
    }
    public void clearDetailsComponent() {
        detailsComponent = null;
    }
    public void clearAddComponent() {
        addComponent = null;
    }

}
