package by.dartec.weathesampleapp.dagger.main;

import by.dartec.weathesampleapp.ui.main.view.MainViewFragment;
import dagger.Subcomponent;

/**
 * Created by root on 07.12.16.
 */

@Subcomponent(modules = {MainModule.class})
@MainScope
public interface MainComponent {
    void inject(MainViewFragment fragment);
}
