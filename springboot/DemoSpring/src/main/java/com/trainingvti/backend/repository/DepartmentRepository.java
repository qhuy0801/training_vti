package com.trainingvti.backend.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.hql.internal.ast.DetailedSemanticException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;
import com.trainingvti.utils.HibernateUtils;

@Repository
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
	
	public void createDetailDepartment(DetailDepartment department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
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
	
	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
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
