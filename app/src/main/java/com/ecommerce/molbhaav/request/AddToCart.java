package com.ecommerce.molbhaav.request;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddToCart {

    @SerializedName("userId")
    @Expose
    private long userId;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("merchantId")
    @Expose
    private String merchantId;
    @SerializedName("quantity")
    @Expose
    private int quantity;

    public AddToCart(long userId, String productId, String merchantId, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.merchantId = merchantId;
        this.quantity=quantity;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
