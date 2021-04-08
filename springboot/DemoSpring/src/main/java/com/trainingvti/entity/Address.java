package com.trainingvti.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trainingvti.entity.Department.DetailDepartment;

@Entity
@Table(name = "Address", catalog = "TestingSystem")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AddressID")
	private short id;

	@Column(name = "AddressName", nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
	private Set<DetailDepartment> departments;

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


	public Set<DetailDepartment> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<DetailDepartment> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + "]";
	}

}
