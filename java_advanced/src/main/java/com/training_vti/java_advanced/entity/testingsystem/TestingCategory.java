package com.training_vti.java_advanced.entity.testingsystem;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Testing_Category", catalog = "TestingSystem")
public class TestingCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private short id;

	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;

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

}
