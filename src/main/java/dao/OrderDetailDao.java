package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.Connection;
import entity.OrderDetail;

public class OrderDetailDao {
	private SessionFactory factory;

	public OrderDetailDao() {
		factory = Connection.getInstance().getSessionFactory();
	}
	
	public boolean addOrderDetailDao(OrderDetail detail) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();
			session.merge(detail);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public OrderDetail find(int idProduct, int orderId) {
		Session session = factory.openSession();
		return session.createNativeQuery("select * from order_detail where order_id = :order_id and product_id = :product_id", OrderDetail.class)
				.setParameter("order_id", orderId)
				.setParameter("product_id", idProduct)
				.getSingleResultOrNull();
	}
}
