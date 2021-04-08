package com.trainingvti.backend.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.trainingvti.entity.Account;
import com.trainingvti.entity.Position.Position;
import com.trainingvti.entity.Salary.Salary;
import com.trainingvti.utils.HibernateUtils;

public class AccountRepository implements IAccountRepository{
	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public List<Account> getAccountAll() {
		Session session = null;

		try {
			// Step 1: create session
			session = hibernateUtils.openSession();

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
			session = hibernateUtils.openSession();
			// transaction is needed for creating since the rollback is necessary precaution
			session.beginTransaction();

			// create group
			Account account = new Account();
			account.setEmail(email);
			account.setUsername(username);
			account.setFirstname(firstname);
			account.setLastname(lastname);
			
			// find department to input
			DepartmentRepository repo = new DepartmentRepository();
			account.setDepartment(repo.getDepartmentID(departmentID));
			
			// for Position and Salary, currently there is not repository for this, will just create method in this class
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

	public Position getPositionID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = hibernateUtils.openSession();
		
			// Step 2: get
			Position position = session.get(Position.class, id);

			return position;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountID(short id) {
		Session session = null;

		try {

			// Step 1: create session
			session = hibernateUtils.openSession();

			// Step 2: get
			Account account = session.get(Account.class, id);

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteAccount(short id) {

		Session session = null;

		try {

			// Step 1: get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Account account = session.load(Account.class, id);

			// delete
			session.delete(account);

			session.getTransaction().commit();

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
			session = hibernateUtils.openSession();

			// Step 2: get
			Salary salary = session.get(Salary.class, id);

			return salary;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
