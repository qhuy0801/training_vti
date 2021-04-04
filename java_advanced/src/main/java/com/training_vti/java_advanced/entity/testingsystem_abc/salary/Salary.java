package com.training_vti.java_advanced.entity.testingsystem_abc.salary;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Salary", catalog = "TestingSystemabc")
public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SalaryID")
	private short id;
	
	@Basic
	private int salaryNameValue;
	
	@Transient
	private SalaryName salaryName;
	
	@PostLoad
	void fillTransient() {
		if (salaryNameValue > 0) {
			this.salaryName = SalaryName.of(salaryNameValue);
		}
	}
	
	@PrePersist
	void fillPersistent() {
		if (salaryName != null) {
			this.salaryNameValue = salaryName.getSalaryName();
		}
	}
}
