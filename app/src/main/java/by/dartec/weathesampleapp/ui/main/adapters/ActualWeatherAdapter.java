package by.dartec.weathesampleapp.ui.main.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import by.dartec.weathesampleapp.R;
import by.dartec.weathesampleapp.data.network.models.weather.ActualWeatherResponse;

/**
 * Created by root on 08.12.16.
 */

public class ActualWeatherAdapter extends RecyclerView.Adapter<ActualWeatherAdapter.ActualWeatherViewHolder> {
    private OnItemClickListener mItemClickListener;
    private List<ActualWeatherResponse> items;
    private LayoutInflater lInflater;
    private Context context;

    public ActualWeatherAdapter(Context context, List<ActualWeatherResponse> items){
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
        this.context = context;
    }

    @Override
    public ActualWeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = lInflater.inflate(R.layout.actual_weather_item, parent, false);
        return new ActualWeatherViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ActualWeatherViewHolder holder, int position) {
        ActualWeatherResponse item = items.get(position);
        setText(holder.txtCity, item.getName());
        setText(holder.txtTemp,
                item.getMain().getTemp() + (char) 0x00B0);
        setText(holder.txtHumidity,
                "humidity: " + item.getMain().getHumidity());
        setText(holder.txtMinMaxTemp,
                "min: " + item.getMain().getTemp_min() + "\n"
                + "max: " + item.getMain().getTemp_max());

        holder.item.setOnClickListener(view -> mItemClickListener.onItemClick(view, position));

        loadImage(holder.imgIcon,
                "http://openweathermap.org/img/w/" + item.getWeather()[0].getIcon() + ".png");
    }

    public void clean() {
        items = Collections.emptyList();
        notifyDataSetChanged();
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

    public void setData(List<ActualWeatherResponse> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    class ActualWeatherViewHolder extends RecyclerView.ViewHolder {
        public View item;
        public ImageView imgIcon;
        public TextView txtCity, txtTemp, txtHumidity, txtMinMaxTemp;

        public ActualWeatherViewHolder(View itemView) {
            super(itemView);
            item = itemView;
            txtMinMaxTemp = (TextView) itemView.findViewById(R.id.txtMinMaxTemp);
            txtHumidity = (TextView) itemView.findViewById(R.id.txtHumidity);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            txtCity = (TextView) itemView.findViewById(R.id.txtCity);
            txtTemp = (TextView) itemView.findViewById(R.id.txtTemp);
        }
    }
}
