package com.ecommerce.molbhaav.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.ecommerce.molbhaav.controller.IApi;
import com.ecommerce.molbhaav.R;
import com.ecommerce.molbhaav.request.SignInRequest;
import com.ecommerce.molbhaav.response.SignInResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        TextView login = (TextView)findViewById(R.id.lnkLogin);
        login.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn=findViewById(R.id.btnLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1 = (EditText)(findViewById(R.id.txtName));
                ed2 =(EditText)(findViewById(R.id.txtPwd));
                ed3 = (EditText)(findViewById(R.id.txtEmail));

                OkHttpClient client = new OkHttpClient.Builder().build();

                final Retrofit retrofit= new Retrofit.Builder().baseUrl("http://allstore.herokuapp.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client).build();
                IApi iApi = retrofit.create(IApi.class);
                SignInRequest signInRequest= new SignInRequest();

                signInRequest.setAddress("ahemdabad");
                signInRequest.setEmailId(ed3.getText().toString());
                signInRequest.setName(ed1.getText().toString());
                signInRequest.setPassword(ed2.getText().toString());
                Toast.makeText(Registration.this, ""+signInRequest.getName(), Toast.LENGTH_SHORT).show();
                iApi.sign(signInRequest).enqueue(new Callback<SignInResponse>() {
                    @Override
                    public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                        System.out.println("Success" + response.body().getUserId());
                        if(response.isSuccessful())
                        {
                            Intent intent = new Intent(Registration.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            System.out.println("error");
                        } }

                    @Override
                    public void onFailure(Call<SignInResponse> call, Throwable t) {
                        System.out.println("error"+ t);
                    }
                });

            }
        });





    } }
