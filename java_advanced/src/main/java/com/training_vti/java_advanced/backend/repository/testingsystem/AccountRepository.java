package com.training_vti.java_advanced.backend.repository.testingsystem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.training_vti.java_advanced.entity.testingsystem.Account;
import com.training_vti.java_advanced.entity.testingsystem.Position.Position;
import com.training_vti.java_advanced.entity.testingsystem.Salary.Salary;
import com.training_vti.java_advanced.entity.testingsystem.department.Department;

public class AccountRepository {
	private SessionFactory sessionFactory;

	public AccountRepository() {
		sessionFactory = buildSessionFactory();
	}

	public List<Account> getAccountAll() {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();

			// Step 2: create hql querry
			Query<Account> query = session.createQuery("FROM Account");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(String email, String username, String firstname, String lastname, short departmentID,
			short positionID, short salaryID) {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();
			// transaction is needed for creating since the rollback is necessary precaution
			session.beginTransaction();

			// create group
			Account account = new Account();
			account.setEmail(email);
			account.setUsername(username);
			account.setFirstname(firstname);
			account.setLastname(lastname);
			account.setDepartment(getDepartmentID(departmentID));
			account.setPosition(getPositionID(positionID));
			account.setSalary(getSalaryID(salaryID));

			// Step 2: create
			session.save(account);

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

	public Department getDepartmentID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = sessionFactory.openSession();

			// Step 2: get
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Position getPositionID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = sessionFactory.openSession();

			// Step 2: get
			Position position = session.get(Position.class, id);

			return position;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Salary getSalaryID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = sessionFactory.openSession();

			// Step 2: get
			Salary salary = session.get(Salary.class, id);

			return salary;

		} finally {
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
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Salary.class);

		// Since Hibernate 4.x, ServiceRegistry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Return Hibernate instance
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
