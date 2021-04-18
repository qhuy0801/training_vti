package com.trainingvti.backend.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;
import com.trainingvti.utils.HibernateUtils;

@Repository
public class DepartmentRepository implements IDepartmentRepository {
	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public DetailDepartment getDepartmentID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = hibernateUtils.openSession();

			// Step 2: get
			DetailDepartment department = session.get(DetailDepartment.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// on working
	public List<DetailDepartment> getDepartmentsID(List<Short> ids) {
		Session session = null;

		try {

			// Step 1: create session
			session = hibernateUtils.openSession();

			// Step 2: get
			List<DetailDepartment> departments = new ArrayList<>();
			
			for (Short id : ids) {
				departments.add(session.get(DetailDepartment.class, id));
			}

			return departments;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteDepartments(List<Short> ids) {
		
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
