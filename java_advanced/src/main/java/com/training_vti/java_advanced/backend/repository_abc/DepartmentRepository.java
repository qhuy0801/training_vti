package com.training_vti.java_advanced.backend.repository_abc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.training_vti.java_advanced.entity.testingsystem.Group;
import com.training_vti.java_advanced.entity.testingsystem_abc.Department;

public class DepartmentRepository {
	private SessionFactory sessionFactory;
	
	public DepartmentRepository() {
		sessionFactory = buildSessionFactory();
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
	
	public Department getDepartmentName(String name) {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();

			// Step 2: create hql querry
			Query<Department> query = session.createQuery("FROM Department WHERE name= :name");

			// Step 3: set parameter
			query.setParameter("name", name);

			// Step 4: get result
			Department department = query.uniqueResult();

			return department;

		} finally {
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

	public void createDepartment(String name) {
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

	public void updateDepartmentName(short id, String newName) {
		Session session = null;

		try {

			// Step 1: create session
			session = sessionFactory.openSession();
			// begin transaction on update
			session.beginTransaction();

			// Step 2: get
			Department department = session.load(Department.class, id);

			// Step 3: set new name
			department.setName(newName);

			// Step 4: commit the changes
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();
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

	public boolean isDepartmentExistsID(short id) {

		// get group
		Department department = getDepartmentID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}
	
	public boolean isDepartmentExistsName(String name) {
		Department department = getDepartmentName(name);

		if (department == null) {
			return false;
		}
		return true;
	}
	
	private SessionFactory buildSessionFactory() {
		// Loading configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate_abc.cfg.xml");

		// Add entity (table name)
		configuration.addAnnotatedClass(Department.class);

		// Since Hibernate 4.x, ServiceRegistry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Return Hibernate instance
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
