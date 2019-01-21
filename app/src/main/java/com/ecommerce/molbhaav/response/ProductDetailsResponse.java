package com.ecommerce.molbhaav.response;

import java.util.List;

public class ProductDetailsResponse{
	private String productImageUrl;
	private List<MerchantDTOListItem> merchantDTOList;
	private String productId;
	private List<StaticAttributeListItem> staticAttributeList;
	private String categoryId;
	private String productDescription;
	private String productName;
	private String productUsp;

	public void setProductImageUrl(String productImageUrl){
		this.productImageUrl = productImageUrl;
	}

	public String getProductImageUrl(){
		return productImageUrl;
	}

	public void setMerchantDTOList(List<MerchantDTOListItem> merchantDTOList){
		this.merchantDTOList = merchantDTOList;
	}

	public List<MerchantDTOListItem> getMerchantDTOList(){
		return merchantDTOList;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setStaticAttributeList(List<StaticAttributeListItem> staticAttributeList){
		this.staticAttributeList = staticAttributeList;
	}

	public List<StaticAttributeListItem> getStaticAttributeList(){
		return staticAttributeList;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductUsp(String productUsp){
		this.productUsp = productUsp;
	}

	public String getProductUsp(){
		return productUsp;
	}

	@Override
 	public String toString(){
		return 
			"ProductDetailsResponse{" + 
			"productImageUrl = '" + productImageUrl + '\'' + 
			",merchantDTOList = '" + merchantDTOList + '\'' + 
			",productId = '" + productId + '\'' + 
			",staticAttributeList = '" + staticAttributeList + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",productDescription = '" + productDescription + '\'' + 
			",productName = '" + productName + '\'' + 
			",productUsp = '" + productUsp + '\'' + 
			"}";
		}
}