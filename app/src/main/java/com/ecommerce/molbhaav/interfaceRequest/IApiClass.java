package com.ecommerce.molbhaav.interfaceRequest;

import com.ecommerce.molbhaav.request.AddToCart;
import com.ecommerce.molbhaav.request.SaveToCartRequest;
import com.ecommerce.molbhaav.response.ProductDetailsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IApiClass {
    @GET("/home")
    public Call<ProductDetailsResponse> getHomeResponse();

    @POST("carts/addToCart")
    public Call<AddToCart> addToCart(@Body AddToCart cart);

    @POST("/saveCart")
    public Call<SaveToCartRequest> saveToCart(@Body SaveToCartRequest saveToCartRequest);

}
