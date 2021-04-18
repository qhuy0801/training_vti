package com.trainingvti.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainingvti.dto.DepartmentDTO;
import com.trainingvti.dto.DepartmentFilter;
import com.trainingvti.entity.Department.Department;
import com.trainingvti.entity.Department.DetailDepartment;
import com.trainingvti.repository.IAddressRepository;
import com.trainingvti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@Autowired
	private IAddressRepository addressRepository;

	// done
	@GetMapping()
	public Page<?> getDepartmentAll(Pageable pageable, DepartmentFilter filter,
			@RequestParam(name = "search", required = false) String search) {

		// get data
		Page<Department> entities = service.getDepartmentAll(pageable, filter, search);

		// convert list entity -> list dto
		Page<DepartmentDTO> dtos = entities.map(new Function<Department, DepartmentDTO>() {
			@Override
			public DepartmentDTO apply(Department entity) {
				DepartmentDTO dto = new DepartmentDTO(entity.getId(), entity.getName(),
						((DetailDepartment) entity).getAddress() == null ? null
								: ((DetailDepartment) entity).getAddress().getId(),
						((DetailDepartment) entity).getEmulationPoint());
				return dto;
			}
		});

		return dtos;
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

		// simply return will work, dont need this
		return new ResponseEntity<DepartmentDTO>(dto, HttpStatus.OK);
	}

	@GetMapping(value = "name/{name}")
	public ResponseEntity<?> getDepartmentID(@PathVariable(name = "name") String name) {
		// declare dto
		DepartmentDTO dto = null;

		// declare entity to fecth data
		Department entity = service.getDepartmentName(name);

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
		entity.setAddress(dto.getAddress() == null ? null : addressRepository.findById(dto.getAddress()).get());
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

	@DeleteMapping
	public void deleteDepartment(@RequestParam(name = "ids") List<Short> ids) {
		service.deleteDepartmens(ids);
	}
}
