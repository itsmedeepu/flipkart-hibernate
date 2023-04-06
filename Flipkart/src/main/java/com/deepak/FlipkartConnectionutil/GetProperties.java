package com.deepak.FlipkartConnectionutil;

import java.util.Properties;

public class GetProperties {

	public static Properties getProperties() {

		Properties prop = new Properties();
		prop.setProperty("hibernate.driver_class", "com.mysql.cj.jdbc.Driver");
		prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/flipkart");
		prop.setProperty("hibernate.connection.username", "root");
		prop.setProperty("hibernate.connection.password", "root");
		prop.setProperty("hibernate.format_sql", "true");
		return prop;
	}

}
