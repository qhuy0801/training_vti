package com.taskmanager.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.taskmanager.entity.account.Account;
import com.taskmanager.entity.task.Task;
import com.taskmanager.utils.HibernateUtils;

public class AccountRepository {
	HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public List<Account> getAccountAll() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Account> query = session.createQuery("FROM Account");
			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get department by id
			Account account = session.get(Account.class, id);
			return account;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createAccount(Account account) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// create
			session.save(account);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteAccount(short id) {
		Session session = null;
		try {
			// get session
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
	
	public boolean isAccountExistsID(short id) {
		// get department
		Account account = getAccountID(id);
		// return result
		if (account == null) {
			return false;
		}
		return true;
	}
}
