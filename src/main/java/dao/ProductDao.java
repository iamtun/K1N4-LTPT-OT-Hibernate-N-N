package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.Connection;
import entity.Product;

public class ProductDao {
	private SessionFactory factory;
	
	public ProductDao() {
		factory = Connection.getInstance().getSessionFactory();
	}
	
	public boolean addProduct(Product product) {
		Session session = factory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		try{
			transaction.begin();
			session.persist(product);
			transaction.commit();
			return true;
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Product findProduct(int id) {
		Session session = factory.openSession();
		return session.find(Product.class, id);
	}
}
