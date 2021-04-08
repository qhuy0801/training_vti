package com.trainingvti.backend.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;
import com.trainingvti.utils.HibernateUtils;

public class DepartmentRepository implements IDepartmentRepository{
	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	public Department getDepartmentID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = hibernateUtils.openSession();

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
			session = hibernateUtils.openSession();
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
			session = hibernateUtils.openSession();

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
			session = hibernateUtils.openSession();
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
			session = hibernateUtils.openSession();

			// Step 2: get
			Address address = session.get(Address.class, id);

			return address;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
