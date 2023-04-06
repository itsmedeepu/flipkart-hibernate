package com.deepak.Flipkart;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.deepak.FlipkartDto.OrderDto;
import com.deepak.FlipkartDto.ProductDto;
import com.deepak.FlipkartEntity.ProductEntity;
import com.deepak.FlipkartRepository.FlipkartRepository;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//		ProductDto productDto = new ProductDto();
//
//		productDto.setName("I PHONE");
//		productDto.setProduct_type("MOBILE");
//
//		productDto.setPrice(140000.0);
//		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
//		Date date = new Date();
//		String date1 = dateFormat.format(date);
//		productDto.setManufacture_date(date1);
//		productDto.setDiscription("this is iphone 14 pro max");
//		productDto.setQuantity(5);

		OrderDto order = new OrderDto();
		order.setProduct_id(1);
		order.setPayment_mode("CASH");
		order.setQuantity(2);
		FlipkartRepository flipkartRepository = new FlipkartRepository();

		flipkartRepository.order(order);
	}
}
