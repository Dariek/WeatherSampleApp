package by.dartec.weathesampleapp;

import android.app.Application;

import by.dartec.weathesampleapp.dagger.Components;

/**
 * Created by root on 07.12.16.
 */

public class MyApp extends Application {

    private static Components components;
    public static Components get() {
        return components;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        components = Components.build(this);
    }
}
