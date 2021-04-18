package com.trainingvti.backend.service;

import java.util.List;

import com.trainingvti.backend.dto.DepartmentDTO;
import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;

public interface IDepartmentService {
	public Department getDepartmentID(short id);
	public List<Department> getDepartmentAll();
	public void deleteDepartment(short id);
	public void createDepartment(Department department);
	public void updateDepartment(short id, DepartmentDTO dto);
	public Address getAddressID(short id);
}
