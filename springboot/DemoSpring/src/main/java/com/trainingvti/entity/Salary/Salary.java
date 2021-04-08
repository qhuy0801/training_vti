package com.trainingvti.entity.Salary;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trainingvti.entity.Account;


@Entity
@Table(name = "Salary", catalog = "TestingSystemabc")
public class Salary implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SalaryID")
	private short id;
	
	@Column(name = "SalaryName", nullable = false)
	@Convert(converter = SalaryConverter.class)
	private SalaryName name;

	@OneToMany(mappedBy = "salary")
	private Set<Account> accounts;
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public SalaryName getName() {
		return name;
	}

	public void setName(SalaryName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", name=" + name + "]";
	}

	
}
