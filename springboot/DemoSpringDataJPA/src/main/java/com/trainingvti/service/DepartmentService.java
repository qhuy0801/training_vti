package com.trainingvti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.trainingvti.dto.DepartmentDTO;
import com.trainingvti.dto.DepartmentFilter;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;
import com.trainingvti.repository.IAddressRepository;
import com.trainingvti.repository.IDepartmentRepository;
import com.trainingvti.specification.DepartmentSpecification;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;
	
	@Autowired
	private IAddressRepository addressRepository;

	public Department getDepartmentID(short id) {
		return departmentRepository.findById(id).get();
	}
	
	public Department getDepartmentName(String name) {
		return departmentRepository.findByName(name);
	}

	public Page<Department> getDepartmentAll(Pageable pageable, DepartmentFilter filter, String search) {
		// specification for searching
		DepartmentSpecification minIdSpecification = new DepartmentSpecification("id", ">=", filter.getMinID());

		DepartmentSpecification maxIdSpecification = new DepartmentSpecification("id", "<=", filter.getMaxID());

		DepartmentSpecification searchSpecification = new DepartmentSpecification("name", "LIKE", search);

		Specification<Department> where = null;

		if (filter.getMinID() != null && filter.getMinID() != 0) {
			where = minIdSpecification;
		}

		if (filter.getMaxID() != null && filter.getMaxID() != 0) {
			if (where == null) {
				where = maxIdSpecification;
			} else {
				where = where.and(maxIdSpecification);
			}
		}

		if (!StringUtils.isEmpty(search)) {
			if (where == null) {
				where = searchSpecification;
			} else {
				where = where.and(searchSpecification);
			}
		}
		
		// returns
		return departmentRepository.findAll(where, pageable);
	}
	
	public void updateDepartment(short id, DepartmentDTO dto) {

		DetailDepartment entity = (DetailDepartment) departmentRepository.findById(id).get();

		if (dto.getName() != null) {
			entity.setName(dto.getName());
		}
		
		if (dto.getAddress() == null) {
			entity.setAddress(null);
		} else {
			entity.setAddress(addressRepository.findById(dto.getAddress()).get());
		}
		
			entity.setEmulationPoint(dto.getEmulationPoint());
	
			departmentRepository.save(entity);
	}

	public void deleteDepartment(short id) {
		departmentRepository.deleteById(id);
	}
	
	public void deleteDepartmens(List<Short> ids) {
		departmentRepository.deleteByIds(ids);
	}

	public void createDepartment(Department department) {
		departmentRepository.save(department);
	}

	public boolean isDepartmentExistsByID(short id) {
		return departmentRepository.existsById(id);
	}
	
	public boolean isDepartmentExistsByName(String name) {
		return departmentRepository.existsByName(name);
	}
}
