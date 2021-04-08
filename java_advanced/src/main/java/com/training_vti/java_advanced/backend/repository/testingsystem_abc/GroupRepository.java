package com.training_vti.java_advanced.backend.repository.testingsystem_abc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.training_vti.java_advanced.entity.testingsystem_abc.Group;

public class GroupRepository {
	private SessionFactory sessionFactory;

	public GroupRepository() {
		sessionFactory = buildSessionFactory();
	}

	public List<Group> getGroupAll() {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();

			// Step 2: create hql querry
			Query<Group> query = session.createQuery("FROM Group");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Group getGroupName(String name) {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();

			// Step 2: create hql querry
			Query<Group> query = session.createQuery("FROM Group WHERE name= :name");

			// Step 3: set parameter
			query.setParameter("name", name);

			// Step 4: get result
			Group group = query.uniqueResult();

			return group;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createGroup(String name, short authorID) {
		Session session = null;

		try {
			// Step 1: create session
			session = buildSessionFactory().openSession();
			// transaction is needed for creating since the rollback is necessary precaution
			session.beginTransaction();

			// create group
			Group group = new Group();
			group.setName(name);

			// Step 2: create
			session.save(group);

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

	public Group getGroupID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = sessionFactory.openSession();

			// Step 2: get
			Group group = session.get(Group.class, id);

			return group;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateGroupName(short id, String newName) {
		Session session = null;

		try {

			// Step 1: create session
			session = sessionFactory.openSession();
			// begin transaction on update
			session.beginTransaction();

			// Step 2: get
			Group group = session.load(Group.class, id);

			// Step 3: set new name
			group.setName(newName);

			// Step 4: commit the changes
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateGroup(Group group) {

		Session session = null;

		try {

			// get session
			session = sessionFactory.openSession();
			session.beginTransaction();

			// update
			session.update(group);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteGroup(short id) {

		Session session = null;

		try {

			// Step 1: get session
			session = sessionFactory.openSession();
			session.beginTransaction();

			// get department
			Group group = session.load(Group.class, id);

			// delete
			session.delete(group);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isGroupExistsID(short id) {

		// get group
		Group group = getGroupID(id);

		// return result
		if (group == null) {
			return false;
		}

		return true;
	}

	public boolean isGroupExistsName(String name) {
		Group group = getGroupName(name);

		if (group == null) {
			return false;
		}
		return true;
	}

	private SessionFactory buildSessionFactory() {
		// Loading configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// Add entity (table name)
		configuration.addAnnotatedClass(Group.class);

		// Since Hibernate 4.x, ServiceRegistry is being used
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		// Return Hibernate instance
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
