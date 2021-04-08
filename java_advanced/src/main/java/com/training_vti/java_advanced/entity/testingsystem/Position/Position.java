package com.training_vti.java_advanced.entity.testingsystem.Position;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.training_vti.java_advanced.entity.testingsystem.Account;

@Entity
@Table(name = "Position", catalog = "TestingSystem")
public class Position {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PositionID")
	private short id;
	
	@Column(name = "PositionName")
	@Enumerated(EnumType.STRING)
	private PositionName name;

	@OneToMany(mappedBy = "position")
	private Set<Account> accounts;
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}


}
