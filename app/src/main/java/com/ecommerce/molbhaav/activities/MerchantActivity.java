package com.ecommerce.molbhaav.activities;

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
import com.ecommerce.molbhaav.adapter.IMerchantContainerCommunicator;
import com.ecommerce.molbhaav.adapter.MerchantListAdapter;
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

public class MerchantActivity extends AppCompatActivity implements IMerchantContainerCommunicator {

    String pId;
    String mId;
    long uId;
    int merchantContainerPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.merchant_list);

        OkHttpClient client = new OkHttpClient.Builder().build();
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo5585107.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final RecyclerView recyclerView=(RecyclerView) findViewById(R.id.merchantRV);
        final List<String> merchantIdList=new ArrayList<>();
        final List<String> merchantNameList=new ArrayList<>();
        final List<Double> merchantPriceList=new ArrayList<>();
        final List<Double> merchantRatingList=new ArrayList<>();
        final ImageView productImageView = (ImageView) findViewById(R.id.imageView);
        final TextView productName = (TextView) findViewById(R.id.productName);
        final TextView productPrice = (TextView) findViewById(R.id.productPrice);
        final TextView description=(TextView) findViewById(R.id.productDescription);

        IApiClass iApiClass = retrofit.create(IApiClass.class);
        iApiClass.getHomeResponse().enqueue(new Callback<ProductDetailsResponse>() {
            @Override
            public void onResponse(Call<ProductDetailsResponse> call, Response<ProductDetailsResponse> response) {
                for(int i=0;i<response.body().getMerchantDTOList().size();i++) {
                    //System.out.println(response.body().getMerchantDTOList().get(i).getName());
                    merchantIdList.add(response.body().getMerchantDTOList().get(i).getMerchantId());
                    merchantNameList.add(response.body().getMerchantDTOList().get(i).getName());
                    merchantPriceList.add(response.body().getMerchantDTOList().get(i).getPrice());
                    merchantRatingList.add(response.body().getMerchantDTOList().get(i).getRating());
                }

                pId= response.body().getProductId();
                uId = 5;
                mId = response.body().getMerchantDTOList().get(merchantContainerPosition).getMerchantId();
                Glide.with(MerchantActivity.this).load(response.body().getProductImageUrl()).into(productImageView);
                productName.setText(response.body().getProductName());
                productPrice.setText(Double.toString(response.body().getMerchantDTOList().get(0).getPrice()));
                description.setText(response.body().getProductDescription());
                MerchantListAdapter merchantListAdapter=new MerchantListAdapter(merchantIdList,merchantNameList,merchantPriceList,merchantRatingList);
                merchantListAdapter.setMethod(MerchantActivity.this);
                recyclerView.setLayoutManager( new LinearLayoutManager(MerchantActivity.this));
                recyclerView.setAdapter(merchantListAdapter);


            }

            @Override
            public void onFailure(Call<ProductDetailsResponse> call, Throwable t) {

            }
        });

//        final Button addToCart = (Button) findViewById(R.id.addToCart);
//        addToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AddToCart cartObject = new AddToCart(uId, pId, mId,1);
//
//                sendNetworkRequest(cartObject);
//            }
//        });
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
                Toast.makeText(MerchantActivity.this, "Item Added to Cart!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<AddToCart> call, Throwable t) {
                Toast.makeText(MerchantActivity.this, "Can't Add Item to Cart, contact developer!", Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public void onClickOfButton(int position){
        merchantContainerPosition=position;
        System.out.println(merchantContainerPosition);
    }

}
