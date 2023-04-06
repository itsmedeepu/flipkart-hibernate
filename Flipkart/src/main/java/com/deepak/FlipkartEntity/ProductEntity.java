package com.deepak.FlipkartEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product_info")
public class ProductEntity implements Serializable {

	@GenericGenerator(name = "uniqueid", strategy = "increment")
	@GeneratedValue(generator = "uniqueid")
	@Id
	@Column(name = "alt_key")
	private int alt_key;
	@Column(name = "name")
	private String name;
	@Column(name = "product_type")
	private String product_type;
	@Column(name = "price")
	private double price;
	@Column(name = "description")
	private String discription;
	@Column(name = "manufacture_date")
	private String manufacture_date;

	public int getAlt_key() {
		return alt_key;
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

	public void setAlt_key(int alt_key) {
		this.alt_key = alt_key;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
