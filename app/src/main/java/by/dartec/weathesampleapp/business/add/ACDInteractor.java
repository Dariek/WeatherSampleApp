package by.dartec.weathesampleapp.business.add;


/**
 * Created by root on 08.12.16.
 */

public class ACDInteractor implements IACDInteractor {
    @Override
    public boolean isValideCityName(String name) {
        //TODO проверка на валидность названия города
        return true;
    }

    @Override
    public boolean ckeckNet() {
        //TODO проверка наличия сети
        return true;
    }
}
