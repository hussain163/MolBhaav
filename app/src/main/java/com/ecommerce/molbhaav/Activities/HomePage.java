package com.ecommerce.molbhaav.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;


import com.ecommerce.molbhaav.Adapter.MyAdapter;
import com.ecommerce.molbhaav.Controller.ItemData;
import com.ecommerce.molbhaav.R;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        ItemData itemsData[] = { new ItemData("Electronics",R.drawable.electronic),
                new ItemData("Fashion",R.drawable.fashion),
                new ItemData("Grocery",R.drawable.grocery),
        };


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter mAdapter = new MyAdapter(itemsData);

        recyclerView.setAdapter(mAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }}
