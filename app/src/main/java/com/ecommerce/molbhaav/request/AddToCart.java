package com.ecommerce.molbhaav.request;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddToCart {

    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("merchantId")
    @Expose
    private String merchantId;

    public AddToCart(String userId, String productId, String merchantId) {
        this.userId = userId;
        this.productId = productId;
        this.merchantId = merchantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }


    @Override
    public String toString() {
        return "AddToCart{" +
                "userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", merchantId='" + merchantId + '\'' +
                '}';
    }
}
