package com.deepak.FlipkartConnectionutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.deepak.FlipkartDto.ProductDto;
import com.deepak.FlipkartEntity.OrderEntity;
import com.deepak.FlipkartEntity.StockEntity;

public class GetConfig {
	public static Configuration getConfiguration() {

			Configuration config = new Configuration();
			config.setProperties(GetProperties.getProperties());
			return config;


	}

}
