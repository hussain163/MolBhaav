package com.ecommerce.molbhaav.Controller;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppControl extends Application {

    public static Retrofit retrofit = null;

    @Override
    public void onCreate() {
        super.onCreate();
        if (retrofit == null){
            OkHttpClient client = new OkHttpClient.Builder().build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client).build();
        }
        System.out.println("lol");
    }
}