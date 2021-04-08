package com.trainingvti.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingvti.backend.dto.DepartmentDTO;
import com.trainingvti.backend.form.DepartmentForm;
import com.trainingvti.backend.service.IDepartmentService;
import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;

@RestController
@RequestMapping(value = "api/v1/departments")
//@CrossOrigin(origins = "http://127.0.0.1:5500")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public ResponseEntity<?> getDepartmentAll() {

		// get data
		List<Department> entities = service.getDepartmentAll();

		// convert list entity -> list dto
		List<DepartmentDTO> dtos = new ArrayList<>();
		for (Department entity : entities) {
			if (entity instanceof DetailDepartment) {
				DepartmentDTO dto = new DepartmentDTO(entity.getId(), entity.getName(),
						((DetailDepartment) entity).getAddress().getId(),
						((DetailDepartment) entity).getEmulationPoint());
				dtos.add(dto);
			} else {
				DepartmentDTO dto = new DepartmentDTO(entity.getId(), entity.getName(), null, null);
				dtos.add(dto);
			}
		}
		// export data
		return new ResponseEntity<List<DepartmentDTO>>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentID(@PathVariable(name = "id") short id) {
		// declare dto
		DepartmentDTO dto = null;

		// convert to department to dto
		if (service.getDepartmentID(id) instanceof Department) {
			dto = new DepartmentDTO(id, service.getDepartmentID(id).getName(), null, null);
		}
		if (service.getDepartmentID(id) instanceof DetailDepartment) {
			dto = new DepartmentDTO(id, service.getDepartmentID(id).getName(),
					((DetailDepartment) service.getDepartmentID(id)).getAddress().getId(),
					((DetailDepartment) service.getDepartmentID(id)).getEmulationPoint());
		}

		return new ResponseEntity<DepartmentDTO>(dto, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO dto) {
		if (dto.getAddress() == null && dto.getEmulationPoint() == null) {
			Department department = new Department();
			department.setName(dto.getName());
		} else {
			DetailDepartment department = new DetailDepartment();
			department.setName(dto.getName());
			Address address = service.getAddressID(dto.getAddress());
			department.setAddress(address);
			department.setEmulationPoint(dto.getEmulationPoint());
			service.createDetailDepartment(department);
		}
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody Department department) {
		department.setId(id);
		service.updateDepartment(department);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
