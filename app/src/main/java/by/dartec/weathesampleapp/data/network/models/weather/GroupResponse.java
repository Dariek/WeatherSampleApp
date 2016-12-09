package by.dartec.weathesampleapp.data.network.models.weather;

import java.util.ArrayList;

/**
 * Created by root on 08.12.16.
 */

public class GroupResponse {
    private String cnt;
    private ArrayList<ActualWeatherResponse> list;

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public ArrayList<ActualWeatherResponse> getList() {
        return list;
    }

    public void setList(ArrayList<ActualWeatherResponse> list) {
        this.list = list;
    }
}
