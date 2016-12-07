package by.dartec.weathesampleapp.data.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 07.12.16.
 */

public class RestAdapter {
    private Retrofit retrofit;
    private Api api;

    public RestAdapter() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Api getAPI() {
        if(api == null) api = retrofit.create(Api.class);
        return api;
    }
}
