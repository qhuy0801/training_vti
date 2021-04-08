package com.taskmanager.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.taskmanager.entity.task.Task;
import com.taskmanager.utils.HibernateUtils;

public class TaskRepository {
	HibernateUtils hibernateUtils;

	public TaskRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public List<Task> getTaskAll() {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// create hql query
			Query<Task> query = session.createQuery("FROM Task");
			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Task getTaskID(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			// get department by id
			Task task = session.get(Task.class, id);
			return task;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createTask(Task task) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// create
			session.save(task);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteTask(short id) {
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get department
			Task task = session.load(Task.class, id);
			// delete
			session.delete(task);
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isTaskExistsID(short id) {
		// get department
		Task task = getTaskID(id);
		// return result
		if (task == null) {
			return false;
		}
		return true;
	}
}
