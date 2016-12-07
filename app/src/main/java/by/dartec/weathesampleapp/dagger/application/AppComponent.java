package by.dartec.weathesampleapp.dagger.application;

import javax.inject.Singleton;

import by.dartec.weathesampleapp.dagger.add.AddComponent;
import by.dartec.weathesampleapp.dagger.add.AddModule;
import by.dartec.weathesampleapp.dagger.details.DetailsComponent;
import by.dartec.weathesampleapp.dagger.details.DetailsModule;
import by.dartec.weathesampleapp.dagger.main.MainComponent;
import by.dartec.weathesampleapp.dagger.main.MainModule;
import by.dartec.weathesampleapp.ui.app.view.MainActivity;
import dagger.Component;
/**
 * Created by root on 07.12.16.
 */


@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);

    AddComponent plus(AddModule mainModule);
    MainComponent plus(MainModule mainModule);
    DetailsComponent plus(DetailsModule mainModule);

}
