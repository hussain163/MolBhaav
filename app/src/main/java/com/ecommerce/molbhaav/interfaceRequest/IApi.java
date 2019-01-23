package com.ecommerce.molbhaav.interfaceRequest;





import com.ecommerce.molbhaav.request.LoginRequest;
import com.ecommerce.molbhaav.request.SaveToCartRequest;
import com.ecommerce.molbhaav.request.SignInRequest;
import com.ecommerce.molbhaav.response.LoginResponse;
import com.ecommerce.molbhaav.response.SignInResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IApi {




    @POST("/users/signIn")
    public Call<SignInResponse> sign(@Body SignInRequest signInRequest);

    @POST("/users/login")
    public Call<LoginResponse>  login(@Body LoginRequest loginRequest);


}
