package by.dartec.weathesampleapp.ui.add.presenter;

import by.dartec.weathesampleapp.ui.add.view.IACDView;

/**
 * Created by root on 07.12.16.
 */

public interface IACDPresenter {
    void bindView(IACDView view);
    void unbindView();
}
