package com.taskmanager.entity.account;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.taskmanager.entity.task.Task;

@Entity
@Table(name = "Account", catalog = "TestingSystem")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "Fullname", length = 30, nullable = false)
	private String name;
	
	@Column(name = "Username", length = 30, nullable = false)
	private String username;
	
	@OneToMany(mappedBy = "account")
	private Set<Task> tasks;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", username=" + username + "]";
	}
	
	
}
