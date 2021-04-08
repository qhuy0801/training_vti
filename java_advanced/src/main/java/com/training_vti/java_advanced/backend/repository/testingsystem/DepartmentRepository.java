package com.training_vti.java_advanced.backend.repository.testingsystem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.training_vti.java_advanced.entity.testingsystem.Account;
import com.training_vti.java_advanced.entity.testingsystem.Address;
import com.training_vti.java_advanced.entity.testingsystem.Position.Position;
import com.training_vti.java_advanced.entity.testingsystem.Salary.Salary;
import com.training_vti.java_advanced.entity.testingsystem.department.Department;
import com.training_vti.java_advanced.entity.testingsystem.department.DetailDepartment;
import com.training_vti.java_advanced.entity.testingsystem_abc.Group;

public class DepartmentRepository {
	private SessionFactory sessionFactory;

	public DepartmentRepository() {
		sessionFactory = buildSessionFactory();
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
	
	public void createDepartment(String name, short emulationPoint, short address) {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();
			// transaction is needed for creating since the rollback is necessary precaution
			session.beginTransaction();

			// create group
			DetailDepartment department = new DetailDepartment();
			department.setName(name);
			department.setEmulationPoint(emulationPoint);
			department.setAddress(getAddressID(address));

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
	
	public List<Department> getDepartmentAll() {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();

			// Step 2: create hql querry
			Query<Department> query = session.createQuery("FROM Department");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteDepartment(short id) {

		Session session = null;

		try {

			// Step 1: get session
			session = sessionFactory.openSession();
			session.beginTransaction();

			// get department
			Department department = session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Address getAddressID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = sessionFactory.openSession();

			// Step 2: get
			Address address = session.get(Address.class, id);

			return address;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	private SessionFactory buildSessionFactory() {
		// Loading configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// Add entity (table name)
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Position.class);
		configuration.addAnnotatedClass(Salary.class);
		configuration.addAnnotatedClass(DetailDepartment.class);
		configuration.addAnnotatedClass(Address.class);

		// Since Hibernate 4.x, ServiceRegistry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Return Hibernate instance
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
