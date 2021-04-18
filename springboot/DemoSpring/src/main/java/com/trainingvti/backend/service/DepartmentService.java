package com.trainingvti.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingvti.backend.dto.DepartmentDTO;
import com.trainingvti.backend.repository.IDepartmentRepository;
import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public Department getDepartmentID(short id) {
		return repository.getDepartmentID(id);
	}

	public List<Department> getDepartmentAll() {
		return repository.getDepartmentAll();
	}

	public void updateDepartment(short id, DepartmentDTO dto) {

		DetailDepartment entity = repository.getDepartmentID(id);

		if (dto.getName() != null) {
			entity.setName(dto.getName());
		}
		
		if (dto.getAddress() == null) {
			entity.setAddress(null);
		} else {
			entity.setAddress(repository.getAddressID(dto.getAddress()));
		}
		
			entity.setEmulationPoint(dto.getEmulationPoint());
	
		repository.updateDepartment(entity);
	}

	public void deleteDepartment(short id) {
		repository.deleteDepartment(id);
	}

	public void createDepartment(Department department) {
		repository.createDepartment(department);
	}

	public Address getAddressID(short id) {
		return repository.getAddressID(id);
	}
}
