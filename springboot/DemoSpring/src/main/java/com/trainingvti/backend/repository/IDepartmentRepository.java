package com.trainingvti.backend.repository;

import java.util.List;

import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;

public interface IDepartmentRepository {
	public DetailDepartment getDepartmentID(short id);
	public List<Department> getDepartmentAll();
	public void deleteDepartment(short id);
	public void createDepartment(Department department);
	public List<DetailDepartment> getDepartmentsID(List<Short> ids);
	public void updateDepartment(Department department);
	public Address getAddressID(short id);
}
