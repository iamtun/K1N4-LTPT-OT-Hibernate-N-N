package app;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.OrderDao;
import dao.OrderDetailDao;
import dao.ProductDao;
import db.Connection;
import entity.OrderDetail;
import entity.v2.Product;
import entity.v2.Order;
import jakarta.persistence.EntityManager;

public class App {
	public static void main(String[] args) {
//		ProductDao productDao = new ProductDao();
//		OrderDao orderDao = new OrderDao();
//		OrderDetailDao detailDao = new OrderDetailDao();
//		productDao.addProduct(new Product("Banh Bo", 10000));
//		orderDao.addOrder(new Order(new Date()));
		
//		Order order =  orderDao.findOrder(1);
//		Product product = productDao.findProduct(2);
//		detailDao.addOrderDetailDao(new OrderDetail(order, product, 1));
//		OrderDetail detail = detailDao.find(1, 2);
//		System.out.println(order.getOrderDetails());
		
		SessionFactory factory = Connection.getInstance().getSessionFactory();
		Set<Product> products = new HashSet<Product>();
		products.add(new Product("Baba"));
		products.add(new Product("Babon"));
		Order order = new Order(products);
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.persist(order);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
