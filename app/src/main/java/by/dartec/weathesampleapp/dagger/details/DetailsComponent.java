package by.dartec.weathesampleapp.dagger.details;

import by.dartec.weathesampleapp.ui.details.view.DetailsFragment;
import dagger.Subcomponent;

/**
 * Created by root on 07.12.16.
 */

@Subcomponent(modules = {DetailsModule.class})
@DetailsScope
public interface DetailsComponent {
    void inject(DetailsFragment fragment);
}
