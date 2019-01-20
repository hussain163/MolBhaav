package com.ecommerce.molbhaav.Controller;





import com.bumptech.glide.request.SingleRequest;
import com.ecommerce.molbhaav.Request.LoginRequest;
import com.ecommerce.molbhaav.Request.SignInRequest;
import com.ecommerce.molbhaav.Response.LoginResponse;
import com.ecommerce.molbhaav.Response.SignInResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApi {




    @POST("/users/signIn")
    public Call<SignInResponse> sign(@Body SignInRequest signInRequest);

    @POST("/users/login")
    public Call<LoginResponse>  login(@Body LoginRequest loginRequest);

//    @GET("config.json")
//    public Call<Object>

}
