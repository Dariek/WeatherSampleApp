package by.dartec.weathesampleapp.dagger.add;

import by.dartec.weathesampleapp.ui.add.view.AddCityDialod;
import dagger.Subcomponent;

/**
 * Created by root on 07.12.16.
 */

@Subcomponent(modules = {AddModule.class})
@AddScope
public interface AddComponent {
    void inject(AddCityDialod dialod);
}
