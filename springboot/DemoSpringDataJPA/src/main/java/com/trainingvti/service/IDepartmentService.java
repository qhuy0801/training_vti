package com.trainingvti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trainingvti.dto.DepartmentDTO;
import com.trainingvti.dto.DepartmentFilter;
import com.trainingvti.entity.Department.Department;

public interface IDepartmentService {
	public Department getDepartmentID(short id);
	public Department getDepartmentName(String name);
	public Page<Department> getDepartmentAll(Pageable pageable, DepartmentFilter filter, String search);
	public void deleteDepartment(short id);
	public void createDepartment(Department department);
	public void updateDepartment(short id, DepartmentDTO dto);
}
