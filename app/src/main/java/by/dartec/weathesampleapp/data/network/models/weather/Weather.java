package by.dartec.weathesampleapp.data.network.models.weather;

/**
 * Created by root on 07.12.16.
 */

public class Weather {
    private String description;
    private String main;
    private String icon;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", icon = " + icon + ", description = " + description + ", main = " + main + "]";
    }
}
