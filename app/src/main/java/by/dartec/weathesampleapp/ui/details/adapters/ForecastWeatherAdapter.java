package by.dartec.weathesampleapp.ui.details.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import by.dartec.weathesampleapp.R;
import by.dartec.weathesampleapp.data.network.models.forecast.ForecastWeatherResponse;
import by.dartec.weathesampleapp.ui.main.adapters.ActualWeatherAdapter;

/**
 * Created by root on 09.12.16.
 */

public class ForecastWeatherAdapter extends RecyclerView.Adapter<ForecastWeatherAdapter.ForecastWeatherViewHolder>{
    private ActualWeatherAdapter.OnItemClickListener mItemClickListener;
    private List<by.dartec.weathesampleapp.data.network.models.forecast.List> items;
    private ForecastWeatherResponse resp;
    private LayoutInflater lInflater;
    private Context context;

    public ForecastWeatherAdapter(Context context, List<by.dartec.weathesampleapp.data.network.models.forecast.List> items){
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
        this.context = context;
    }

    @Override
    public ForecastWeatherAdapter.ForecastWeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = lInflater.inflate(R.layout.forecast_item, parent, false);
        return new ForecastWeatherAdapter.ForecastWeatherViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ForecastWeatherAdapter.ForecastWeatherViewHolder holder, int position) {
        by.dartec.weathesampleapp.data.network.models.forecast.List item = items.get(position);
        String buf[] = item.getDt_txt().split(" ");

        setText(holder.txtDate, buf[0]);
        setText(holder.txtTime, buf[1]);
        setText(holder.txtTemp,
                item.getMain().getTemp() + (char) 0x00B0);
        setText(holder.txtHumidity,
                "humidity: " + item.getMain().getHumidity());
        setText(holder.txtMinMaxTemp,
                "min: " + item.getMain().getTemp_min() + "\n"
                        + "max: " + item.getMain().getTemp_max());
        loadImage(holder.imgIcon,
                "http://openweathermap.org/img/w/" + item.getWeather().get(0).getIcon() + ".png");
    }

    private void setText(TextView view, String text) {
        view.setText(text);
    }

    private void loadImage(ImageView view, String url) {
        Picasso.with(context).load(url).into(view);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(ForecastWeatherResponse resp) {
        this.items = resp.getList();
        notifyDataSetChanged();
        this.resp = resp;
    }

    public void clean() {
        items = Collections.emptyList();
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final ActualWeatherAdapter.OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    class ForecastWeatherViewHolder extends RecyclerView.ViewHolder {
        public View item;
        public ImageView imgIcon;
        public TextView txtCity, txtTemp, txtHumidity, txtMinMaxTemp, txtDate, txtTime;

        public ForecastWeatherViewHolder(View itemView) {
            super(itemView);
            item = itemView;
            txtMinMaxTemp = (TextView) itemView.findViewById(R.id.txtMinMaxTemp);
            txtHumidity = (TextView) itemView.findViewById(R.id.txtHumidity);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            txtCity = (TextView) itemView.findViewById(R.id.txtCity);
            txtTemp = (TextView) itemView.findViewById(R.id.txtTemp);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            txtTime = (TextView) itemView.findViewById(R.id.txtTime);
        }
    }
}
