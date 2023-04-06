package com.deepak.FlipkartRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.deepak.FlipkartConnectionutil.GetConfig;
import com.deepak.FlipkartDto.OrderDto;
import com.deepak.FlipkartDto.ProductDto;
import com.deepak.FlipkartEntity.OrderEntity;
import com.deepak.FlipkartEntity.ProductEntity;
import com.deepak.FlipkartEntity.StockEntity;

public class FlipkartRepository {
	public void prepareProductStockInfo(ProductDto productDto) {

		Configuration config = GetConfig.getConfiguration();
		config.addAnnotatedClass(ProductEntity.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ProductEntity merge = (ProductEntity) session.merge(getProductEntity(productDto));
		transaction.commit();
		session.close();
		updateStocks(merge.getAlt_key(), productDto.getQuantity());

	}

	public ProductEntity getProductEntityById(int id) {
		Configuration config = GetConfig.getConfiguration();
		config.addAnnotatedClass(ProductEntity.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		StringBuilder builder = new StringBuilder();
		builder.append("from ProductEntity where alt_key=:n");
		Query query = session.createQuery(builder.toString());
		query.setParameter("n", id);

		List list = query.getResultList();
		session.close();
		Optional findFirst = list.stream().findFirst();
		ProductEntity productEntity = (ProductEntity) findFirst.get();

		return productEntity;

	}

	public void order(OrderDto orderDto) {
		OrderEntity orderEntity = getOrderEntity(orderDto);
		Configuration config = GetConfig.getConfiguration();
		config.addAnnotatedClass(OrderEntity.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		OrderEntity orderEntity2 = (OrderEntity) session.merge(orderEntity);
		transaction.commit();
		session.close();
		//call stocks for updating the quntity
		update_Stocks(orderEntity2);

	}

	private void updateStocks(int id, int quantity) {

		Configuration config = GetConfig.getConfiguration();
		config.addAnnotatedClass(StockEntity.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(getStockEntity(id, quantity));
		transaction.commit();
		session.close();

	}

	private ProductEntity getProductEntity(ProductDto productDto) {

		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productDto.getName());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setProduct_type(productDto.getProduct_type());
		productEntity.setDiscription(productDto.getDiscription());
		productEntity.setManufacture_date(productDto.getManufacture_date());

		return productEntity;
	}

	private StockEntity getStockEntity(int id, int quantity) {
		StockEntity stockEntity = new StockEntity();

		stockEntity.setProduct_id(id);
		stockEntity.setQuantity(quantity);

		return stockEntity;

	}

	private OrderEntity getOrderEntity(OrderDto orderDto) {

		ProductEntity productEntity = getProductEntityById(orderDto.getProduct_id());

		int product_id = orderDto.getProduct_id();
		int quantity = orderDto.getQuantity();
		String payment_mode = orderDto.getPayment_mode();
		double totalprice = orderDto.getQuantity() * productEntity.getPrice();

		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();

		String datef = dateFormat.format(date);

		OrderEntity orderEntity = new OrderEntity();

		orderEntity.setProduct_id(product_id);
		orderEntity.setQuantity(quantity);
		orderEntity.setPayment_mode(payment_mode);
		orderEntity.setTotal_price(totalprice);
		orderEntity.setSold_date(datef);
		return orderEntity;

	}

	private StockEntity getStockEntityById(int id) {
		Configuration config = GetConfig.getConfiguration();
		config.addAnnotatedClass(StockEntity.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		StringBuilder builder = new StringBuilder();
		builder.append("from StockEntity where product_id=:n");
		Query query = session.createQuery(builder.toString());
		query.setParameter("n", id);
		List list = query.getResultList();
		session.close();
		Optional findFirst = list.stream().findFirst();
		StockEntity stockEntity = (StockEntity) findFirst.get();

		return stockEntity;

	}

	private int update_Stocks(OrderEntity orderEntity) {
		Configuration config = GetConfig.getConfiguration();
		StockEntity stockEntityById = getStockEntityById(orderEntity.getProduct_id());
		System.out.println(stockEntityById);
		
		int stocksleft = stockEntityById.getQuantity() - orderEntity.getQuantity();
		config.addAnnotatedClass(StockEntity.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		StringBuilder builder = new StringBuilder();
		builder.append("update StockEntity set quantity=:stocksleft where product_id=:productid");
		Query query = session.createQuery(builder.toString());
		query.setParameter("stocksleft", stocksleft);
		query.setParameter("productid", orderEntity.getProduct_id());

		int update = query.executeUpdate();

		transaction.commit();
		session.close();
		return update;

	}

}
