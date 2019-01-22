package com.ecommerce.molbhaav.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ecommerce.molbhaav.R;

import java.util.ArrayList;
import java.util.List;

public class MerchantListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> merchantIdList = new ArrayList<>();
    private List<String> merchantNameList = new ArrayList<>();
    private List<Double> merchantPriceList = new ArrayList<>();
    private List<Double> merchantRatingList = new ArrayList<>();
    int merchantContainerPosition;
    IMerchantContainerCommunicator iMerchantContainerCommunicator;

    public MerchantListAdapter(List<String> merchantIdList, List<String> merchantNameList, List<Double> merchantPriceList, List<Double> merchantRatingList) {
        this.merchantIdList = merchantIdList;
        this.merchantNameList = merchantNameList;
        this.merchantPriceList = merchantPriceList;
        this.merchantRatingList = merchantRatingList;
    }

    public void setMethod(IMerchantContainerCommunicator iMerchantContainerCommunicator){
        this.iMerchantContainerCommunicator=iMerchantContainerCommunicator;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.merchant_detail_container, viewGroup, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //for(int j=0;j<merchantIdList.size();j++){
            System.out.println("Hiii" +  merchantNameList.get(i) +  merchantPriceList.get(i) + merchantRatingList.get(i));
            ((TextViewHolder) viewHolder).bind(merchantNameList.get(i), merchantPriceList.get(i), merchantRatingList.get(i));
    }

    @Override
    public int getItemCount() {
        return merchantIdList.size();
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        TextView merchantName;
        TextView merchantPrice;
        RatingBar merchantRating;
        Button communicatorButton;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            merchantName=(TextView) itemView.findViewById(R.id.merchantName);
            merchantPrice=(TextView) itemView.findViewById(R.id.productPrice);
            merchantRating=(RatingBar) itemView.findViewById(R.id.ratingBar);
            communicatorButton=(itemView).findViewById(R.id.addToCartButton);
        }
        public void bind(String name, Double price, Double rating){
            merchantName.setText(name);
            merchantPrice.setText(Double.toString(price));
            float frating=rating.floatValue();
            merchantRating.setRating(frating);
            communicatorButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    merchantContainerPosition=getAdapterPosition();
                    iMerchantContainerCommunicator.onClickOfButton(merchantContainerPosition);
                }

            });
        }
    }
}
