package com.ecommerce.molbhaav.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.ecommerce.molbhaav.R;
import com.ecommerce.molbhaav.adapter.StaticAttributesListAdapter;
import com.ecommerce.molbhaav.interfaceRequest.IApiClass;
import com.ecommerce.molbhaav.request.AddToCart;
import com.ecommerce.molbhaav.response.ProductDetailsResponse;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import okhttp3.OkHttpClient;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDetailsActivity extends AppCompatActivity {

    String pId;
    String mId;
    long uId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        final RecyclerView recyclerView=findViewById(R.id.attributesRV);
        final ImageView productImageView = (ImageView) findViewById(R.id.productImageView);
        final TextView productName = (TextView) findViewById(R.id.pName);
        final TextView productPrice = (TextView) findViewById(R.id.productPrice);
        final TextView productUsp = (TextView) findViewById(R.id.productUsp);
        final TextView soldBy = (TextView) findViewById(R.id.merchantName);
        final TextView description=(TextView) findViewById(R.id.productDescription);
        final Button merchantButton=(Button) findViewById(R.id.viewMerchantList);
        final List<String> attributeKey=new ArrayList<>();
        final List<String> attributeValue=new ArrayList<>();

        OkHttpClient client = new OkHttpClient.Builder().build();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo5585107.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        IApiClass iApiClass = retrofit.create(IApiClass.class);
        iApiClass.getHomeResponse().enqueue(new Callback<ProductDetailsResponse>(){
            @Override
            public void onResponse(Call<ProductDetailsResponse> call, Response<ProductDetailsResponse> response) {
                System.out.println(response.body().getProductImageUrl());
                Glide.with(ProductDetailsActivity.this).load(response.body().getProductImageUrl()).into(productImageView);
                productName.setText(response.body().getProductName());
                productPrice.setText(Double.toString(response.body().getMerchantDTOList().get(0).getPrice()));
                productUsp.setText(response.body().getProductUsp());
                soldBy.setText(response.body().getMerchantDTOList().get(0).getName());
                description.setText(response.body().getProductDescription());

                pId = response.body().getProductId();
                uId = 5;
                mId = response.body().getMerchantDTOList().get(0).getMerchantId();

                for(int i=0;i<response.body().getStaticAttributeList().size();i++){
                    attributeKey.add(response.body().getStaticAttributeList().get(i).getAttribute());
                    attributeValue.add(response.body().getStaticAttributeList().get(i).getAttributeDescription());

                }
                StaticAttributesListAdapter staticAttributesListAdapter=new StaticAttributesListAdapter(attributeKey, attributeValue);
                recyclerView.setLayoutManager( new LinearLayoutManager(ProductDetailsActivity.this));
                recyclerView.setAdapter(staticAttributesListAdapter);
            }

            @Override
            public void onFailure(Call<ProductDetailsResponse> call, Throwable t) {
                System.out.println("Failure");
            }
        });


        final Button addToCart = (Button) findViewById(R.id.addToCart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddToCart cartObject = new AddToCart(uId, pId, mId,1);
                sendNetworkRequest(cartObject);
                Intent intent=new Intent(ProductDetailsActivity.this, MyCartActivity.class);
                startActivity(intent);

            }
        });

        merchantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductDetailsActivity.this, MerchantActivity.class);
                startActivity(intent);
            }
        });

    }

    public void sendNetworkRequest(AddToCart cartObject){
        Retrofit.Builder builder =new Retrofit.Builder()
                .baseUrl("http://demo5585107.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        IApiClass iApiClass = retrofit.create(IApiClass.class);
        Call<AddToCart> call = iApiClass.addToCart(cartObject);
        call.enqueue(new Callback<AddToCart>() {
            @Override
            public void onResponse(Call<AddToCart> call, Response<AddToCart> response) {
                Toast.makeText(ProductDetailsActivity.this, "Item Added to Cart!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<AddToCart> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "Can't Add Item to Cart, contact developer!", Toast.LENGTH_LONG).show();
            }
        });

    }

}

