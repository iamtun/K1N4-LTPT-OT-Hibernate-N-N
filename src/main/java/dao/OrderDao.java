package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.Connection;
import entity.Order;

public class OrderDao {
	private SessionFactory factory;

	public OrderDao() {
		factory = Connection.getInstance().getSessionFactory();
	}

	public boolean addOrder(Order order) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();
			session.persist(order);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
	public Order findOrder(int id) {
		Session session = factory.openSession();
		return session.find(Order.class, id);
	}
}
