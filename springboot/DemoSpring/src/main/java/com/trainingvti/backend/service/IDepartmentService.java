package com.trainingvti.backend.service;

import java.util.List;

import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;

public interface IDepartmentService {
	public Department getDepartmentID(short id);
	public List<Department> getDepartmentAll();
	public void deleteDepartment(short id);
	public void createDetailDepartment(DetailDepartment department);
	public void updateDepartment(Department department);
	public Address getAddressID(short id);
}
