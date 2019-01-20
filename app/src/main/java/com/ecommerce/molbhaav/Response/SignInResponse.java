package com.ecommerce.molbhaav.Response;



import com.google.gson.annotations.SerializedName;


public class SignInResponse{

    @SerializedName("password")
    private String password;

    @SerializedName("address")
    private String address;

    @SerializedName("name")
    private String name;

    @SerializedName("emailId")
    private String emailId;

    @SerializedName("userId")
    private int userId;

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

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
                "Response{" +
                        "password = '" + password + '\'' +
                        ",address = '" + address + '\'' +
                        ",name = '" + name + '\'' +
                        ",emailId = '" + emailId + '\'' +
                        ",userId = '" + userId + '\'' +
                        "}";
    }
}