package by.dartec.weathesampleapp.data.network.models.forecast;

import java.util.ArrayList;

/**
 * Created by root on 09.12.16.
 */

public class List {
    private ArrayList<Weather> weather;
    private Clouds clouds;
    private String dt_txt;
    private String dt;
    private Wind wind;
    private Main main;
    private Sys sys;

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "ClassPojo [clouds = " + clouds + ", dt = " + dt + ", wind = " + wind + ", sys = " + sys + ", weather = " + weather + ", dt_txt = " + dt_txt + ", main = " + main + "]";
    }
}
