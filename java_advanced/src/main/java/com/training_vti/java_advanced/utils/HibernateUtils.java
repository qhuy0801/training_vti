package com.training_vti.java_advanced.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.training_vti.java_advanced.entity.testingsystem.Group;

public class HibernateUtils {
	
	private static HibernateUtils instance;

	private Configuration configuration;
	private SessionFactory sessionFactory;

	// get instance of HibernateUtils
	public static HibernateUtils getInstance() {
		if (instance == null) {
			instance = new HibernateUtils();
		}
		return instance;
	}

	// make constructor private > can not initialize this class from outside
	private HibernateUtils() {
		configure();
	}

	private void configure() {
		// Loading configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// Add entity (table name)
		configuration.addAnnotatedClass(Group.class);
	}

	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		// Return Hibernate instance
		return sessionFactory;
	}

	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}
	
	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}
}
