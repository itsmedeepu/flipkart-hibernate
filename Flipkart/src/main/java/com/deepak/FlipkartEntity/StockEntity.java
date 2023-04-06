package com.deepak.FlipkartEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "stock_info")
public class StockEntity implements Serializable {
	@GenericGenerator(name = "uniqueid", strategy = "increment")
	@GeneratedValue(generator = "uniqueid")
	@Id
	@Column(name = "alt_key")
	private int alt_key;

	@Column(name = "product_id")
	private int product_id;

	@Column(name = "quantity")
	private int quantity;

	public int getAlt_key() {
		return alt_key;
	}

	public int getProduct_id() {
		return product_id;
	}

	public int getQuantity() {
		return quantity;
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



}
