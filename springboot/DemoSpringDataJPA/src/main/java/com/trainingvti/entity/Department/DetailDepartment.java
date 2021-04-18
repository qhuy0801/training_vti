package com.trainingvti.entity.Department;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.trainingvti.entity.Address;

@Entity
@Table(name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department implements Serializable {
	private static final long serialVersionUID = 1L;

//	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AddressID", nullable = true)
	private Address address;

	@Column(name = "EmulationPoint", nullable = true)
	private Short emulationPoint;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Short getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(Short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	@Override
	public String toString() {
		return "DetailDepartment [getId()=" + getId() + ", address=" + address + ", emulationPoint=" + emulationPoint
				+ "]";
	}

}