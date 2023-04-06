package com.deepak.FlipkartDto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	private String name;
	private String product_type;
	private double price;
	private String discription;
	private String manufacture_date;
	private int quantity;

	public String getName() {
		return name;
	}

	public String getProduct_type() {
		return product_type;
	}

	public double getPrice() {
		return price;
	}

	public String getDiscription() {
		return discription;
	}

	public String getManufacture_date() {
		return manufacture_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public void setManufacture_date(String manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
