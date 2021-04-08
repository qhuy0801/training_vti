package com.training_vti.java_advanced.entity.testingsystem.department;

import java.io.Serializable;

import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.training_vti.java_advanced.entity.testingsystem.Address;

@Entity
@Table(name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AddressID", nullable = false)
	private Address address;
	
	@Column(name = "EmulationPoint", nullable = true)
	private short emulationPoint;

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public short getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	@Override
	public String toString() {
		return "DetailDepartment [getId()=" + getId() + ", address=" + address + ", emulationPoint=" + emulationPoint
				+ "]";
	}

	
}
