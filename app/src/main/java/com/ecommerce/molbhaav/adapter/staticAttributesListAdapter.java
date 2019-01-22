package com.ecommerce.molbhaav.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecommerce.molbhaav.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StaticAttributesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> attributeKey=new ArrayList<>();
    private List<String> attributesValue = new ArrayList<>();

    public StaticAttributesListAdapter(List<String> attributeKey, List<String> attributesValue) {
        this.attributeKey = attributeKey;
        this.attributesValue = attributesValue;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.static_attribute_list, viewGroup, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            ((TextViewHolder) viewHolder).bind(attributeKey.get(i), attributesValue.get(i));
    }

    @Override
    public int getItemCount () {

        return attributeKey.size();
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        TextView key1;
        TextView value1;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            key1 = itemView.findViewById(R.id.key1);
            value1 = itemView.findViewById(R.id.value1);
        }

        public void bind(String key1, String value1) {
            this.key1.setText(key1);
            this.value1.setText(value1);
        }
    }
}