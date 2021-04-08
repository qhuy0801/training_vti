package com.training_vti.java_advanced.entity.testingsystem;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.training_vti.java_advanced.entity.testingsystem.Position.Position;
import com.training_vti.java_advanced.entity.testingsystem.Salary.Salary;
import com.training_vti.java_advanced.entity.testingsystem.department.Department;

@Entity
@Table(name = "Account", catalog = "TestingSystem")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccountID")
	private short id;

	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	@Column(name = "Username", nullable = false, unique = true)
	private String username;

	@Column(name = "FirstName", nullable = false)
	private String firstname;

	@Column(name = "LastName", nullable = false)
	private String lastname;

	@ManyToOne
	@JoinColumn(name = "DepartmentID", nullable = false)
	private Department department;

	@ManyToOne
	@JoinColumn(name = "PositionID", nullable = false)
	private Position position;

	@ManyToOne
	@JoinColumn(name = "SalaryID", nullable = false)
	private Salary salary;

	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createDate;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Date getCreateDate() {
		return createDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", username=" + username + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", department=" + department + ", position=" + position + ", salary="
				+ salary + ", createDate=" + createDate + "]";
	}
}
