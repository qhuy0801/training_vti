package com.training_vti.java_advanced.backend.repository_abc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.training_vti.java_advanced.entity.testingsystem_abc.Department;
import com.training_vti.java_advanced.entity.testingsystem_abc.salary.Salary;

public class SalaryDepository {
	private SessionFactory sessionFactory;
	
	public SalaryDepository() {
		sessionFactory = buildSessionFactory();
	}
	
	public void createSalary(String name) {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();
			// transaction is needed for creating since the rollback is necessary precaution
			session.beginTransaction();

			// create group
			Department department = new Department();
			department.setName(name);

			// Step 2: create
			session.save(department);

			System.out.println("Create successfully");

			// Step 3: commnit
			session.getTransaction().commit();
		} catch (Exception sqlException) {
			// Step 4 (just in case action is failed to finish): rollback transaction
			if (null != session.getTransaction()) {
				sqlException.printStackTrace();
				System.out.println("\n...Transaction is being rolled back...");
				session.getTransaction().rollback();
			}
		} finally {
			// Step 5: Close session
			if (session != null) {
				session.close();
			}
		}
	}
	
	private SessionFactory buildSessionFactory() {
		// Loading configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate_abc.cfg.xml");

		// Add entity (table name)
		configuration.addAnnotatedClass(Salary.class);

		// Since Hibernate 4.x, ServiceRegistry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Return Hibernate instance
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
