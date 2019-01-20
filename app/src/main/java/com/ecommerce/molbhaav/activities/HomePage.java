package com.ecommerce.molbhaav.activities;

import android.os.Bundle;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.ecommerce.molbhaav.adapter.MyAdapter;
import com.ecommerce.molbhaav.controller.ItemData;
import com.ecommerce.molbhaav.R;

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
