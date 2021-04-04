package com.training_vti.java_advanced.backend.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.training_vti.java_advanced.entity.testingsystem.TestingCategory;

public class TestHibernate_TestingCategory {
	public static void main(String[] args) {
		//Decleare session
		Session session = null;
		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();
			session.beginTransaction();
			
			// create new test category
			TestingCategory category = new TestingCategory();
			category.setName("Hibernate1");

			// Step 2: create
			session.save(category);

			System.out.println("Create success!");
			
			// Step 3: commnit
			session.getTransaction().commit();
		} finally {
			// Step 5: Close session
			if (session != null) {
				session.close();
			}
		}

	}

	private static SessionFactory buildSessionFactory() {
		// load configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(TestingCategory.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		return configuration.buildSessionFactory(serviceRegistry);
	}
}
