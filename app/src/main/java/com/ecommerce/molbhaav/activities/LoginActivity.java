package com.ecommerce.molbhaav.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import com.ecommerce.molbhaav.controller.IApi;
import com.ecommerce.molbhaav.R;
import com.ecommerce.molbhaav.request.LoginRequest;
import com.ecommerce.molbhaav.response.LoginResponse;

public class LoginActivity extends AppCompatActivity {
        String user;
        EditText ed;
        EditText ed1;
        Button btn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            ed = (EditText) (findViewById(R.id.txtEmail));
            ed1 = (EditText) (findViewById(R.id.txtPwd));
            btn = findViewById(R.id.btnLogin);

            TextView register = (TextView) findViewById(R.id.lnkRegister);
            register.setMovementMethod(LinkMovementMethod.getInstance());
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, Registration.class);
                    startActivity(intent);
                }
            });


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    OkHttpClient client = new OkHttpClient.Builder().build();

                    final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://allstore.herokuapp.com")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(client).build();
                    IApi iApi = retrofit.create(IApi.class);


                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setName(ed.getText().toString());
                    loginRequest.setEmailId(ed1.getText().toString());
                    Toast.makeText(LoginActivity.this, "" + ed.getText().toString(), Toast.LENGTH_SHORT).show();
                    iApi.login(loginRequest).enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                        if(response.isSuccessful()){


                            Intent intent = new Intent(LoginActivity.this, HomePage.class);
                            startActivity(intent);
//                        SharedPreferences sharedPreferences= getSharedPreferences("package com.example.projectfinal;", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor=sharedPreferences.edit();
//                        int i= response.body().getUserId();
//                        editor.putInt("user",i);
//                        Toast.makeText(LoginActivity.this, ""+sharedPreferences.getInt("user",0), Toast.LENGTH_SHORT).show();
//                        editor.commit();
//                        editor.apply();


//                        }else{
//                            Toast.makeText(LoginActivity.this, "Invalid Details", Toast.LENGTH_SHORT).show();
//                            System.out.println("error");

//                        }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            System.out.println("Call error");
                        }
                    });


                }
            });
        }
    }