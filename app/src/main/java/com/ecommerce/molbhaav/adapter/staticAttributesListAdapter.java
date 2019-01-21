package com.ecommerce.molbhaav.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecommerce.molbhaav.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class staticAttributesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Map<String, String> attributesList = new HashMap<>();

    public staticAttributesListAdapter(Map<String, String> attributesList) {
        this.attributesList = attributesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.static_attribute_list, viewGroup, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Iterator hmIterator = attributesList.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            ((TextViewHolder) viewHolder).bind(mapElement.getKey().toString(), mapElement.getValue().toString());
        }
    }

        @Override
        public int getItemCount () {

        return attributesList.size();
        }

        class TextViewHolder extends RecyclerView.ViewHolder {
            public TextView key1;
            public TextView value1;
            public TextView key2;
            public TextView value2;

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
