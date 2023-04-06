package com.deepak.FlipkartDto;

import java.io.Serializable;

public class OrderDto implements Serializable {

	private int product_id;
	private int quantity;

	private String payment_mode;

	public int getProduct_id() {
		return product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

}
