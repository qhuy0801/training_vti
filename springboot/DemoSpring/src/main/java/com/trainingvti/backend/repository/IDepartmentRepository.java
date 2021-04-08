package com.trainingvti.backend.repository;

import java.util.List;

import com.trainingvti.entity.Department.Department;

public interface IDepartmentRepository {
	public Department getDepartmentID(short id);
	public void createDepartment(String name, short emulationPoint, short address);
	public List<Department> getDepartmentAll();
	public void deleteDepartment(short id);
}
