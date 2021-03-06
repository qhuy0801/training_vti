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
import com.trainingvti.backend.service.IDepartmentService;
import com.trainingvti.entity.Address;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	// done
	@GetMapping()
	public ResponseEntity<?> getDepartmentAll() {

		// get data
		List<Department> entities = service.getDepartmentAll();

		// convert list entity -> list dto
		List<DepartmentDTO> dtos = new ArrayList<>();

		for (Department entity : entities) {
			DepartmentDTO dto = new DepartmentDTO(entity.getId(), entity.getName(),
					((DetailDepartment) entity).getAddress() == null ? null
							: ((DetailDepartment) entity).getAddress().getId(),
					((DetailDepartment) entity).getEmulationPoint());
			dtos.add(dto);
		}
		// export data
		return new ResponseEntity<List<DepartmentDTO>>(dtos, HttpStatus.OK);
	}

	// done
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentID(@PathVariable(name = "id") short id) {
		// declare dto
		DepartmentDTO dto = null;

		// declare entity to fecth data
		Department entity = service.getDepartmentID(id);

		dto = new DepartmentDTO(entity.getId(), entity.getName(),
				((DetailDepartment) entity).getAddress() == null ? null
						: ((DetailDepartment) entity).getAddress().getId(),
				((DetailDepartment) entity).getEmulationPoint());

		return new ResponseEntity<DepartmentDTO>(dto, HttpStatus.OK);
	}

	// done
	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO dto) {

		DetailDepartment entity = new DetailDepartment();
		entity.setName(dto.getName());
		entity.setEmulationPoint(dto.getEmulationPoint());
		entity.setAddress(dto.getAddress() == null ? null : service.getAddressID(dto.getAddress()));
		service.createDepartment(entity);

		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentDTO dto) {

		service.updateDepartment(id, dto);

		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	// done
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
