package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.v2.Order;
import entity.v2.Product;


public class Connection {
	private static Connection instance;
	private SessionFactory sessionFactory;

	StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

	Metadata metadata = new MetadataSources(serviceRegistry)
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(Order.class)
			.getMetadataBuilder().build();
	
	private Connection() {
		sessionFactory = metadata.getSessionFactoryBuilder().build();
	}
	
	public synchronized static Connection getInstance() {
		if(instance == null) {
			instance = new Connection();
		}
		
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
