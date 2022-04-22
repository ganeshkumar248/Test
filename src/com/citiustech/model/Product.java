package com.citiustech.model;

public class Product {

	private int prodId;
	private String prodName;
	private float prodPrice; 
	private String prodCategory;
	
	public Product() {

	}

	public Product(int prodId, String prodName, float prodPrice, String prodCategory) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodCategory = prodCategory;
	} 
	public int getProdId() {
		return prodId;
	} 
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public float getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodCategory="
				+ prodCategory + "]";
	}
	
}
