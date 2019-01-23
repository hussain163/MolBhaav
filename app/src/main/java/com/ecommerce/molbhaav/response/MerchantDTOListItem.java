package com.ecommerce.molbhaav.response;

public class MerchantDTOListItem{
	private int quantity;
	private String merchantId;
	private double price;
	private String name;
	private String emailId;
	private int rank;
	private double rating;

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setMerchantId(String merchantId){
		this.merchantId = merchantId;
	}

	public String getMerchantId(){
		return merchantId;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MerchantDTOListItem{" +
				"quantity=" + quantity +
				", merchantId='" + merchantId + '\'' +
				", price=" + price +
				", name='" + name + '\'' +
				", emailId='" + emailId + '\'' +
				", rank=" + rank +
				", rating=" + rating +
				'}';
	}
}
