package com.ecommerce.molbhaav.response;



import com.google.gson.annotations.SerializedName;


public class LoginResponse{

    @SerializedName("name")
    private String name;

    @SerializedName("emailId")
    private String emailId;

    @SerializedName("userId")
    private int userId;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmailId(String emailId){
        this.emailId = emailId;
    }

    public String getEmailId(){
        return emailId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getUserId(){
        return userId;
    }

    @Override
    public String toString(){
        return
                "LoginResponse{" +
                        "name = '" + name + '\'' +
                        ",emailId = '" + emailId + '\'' +
                        ",userId = '" + userId + '\'' +
                        "}";
    }
}