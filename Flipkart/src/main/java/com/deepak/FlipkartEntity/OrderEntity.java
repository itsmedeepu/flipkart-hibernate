package com.deepak.FlipkartEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_info")
public class OrderEntity implements Serializable {
	@GenericGenerator(name = "uniqueid", strategy = "increment")
	@GeneratedValue(generator = "uniqueid")
	@Id
	@Column(name = "alt_key")
	private int alt_key;
	@Column(name = "product_id")
	private int product_id;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "total_price")
	private double total_price;

	@Column(name = "sold_date")
	private String sold_date;
	@Column(name = "payment_mode")
	private String payment_mode;

	public int getAlt_key() {
		return alt_key;
	}

	public int getProduct_id() {
		return product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public String getSold_date() {
		return sold_date;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setAlt_key(int alt_key) {
		this.alt_key = alt_key;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public void setSold_date(String sold_date) {
		this.sold_date = sold_date;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

}
