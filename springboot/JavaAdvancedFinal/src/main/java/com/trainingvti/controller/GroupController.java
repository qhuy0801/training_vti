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

import com.trainingvti.dto.GroupDTO;
import com.trainingvti.dto.GroupDTOOut;
import com.trainingvti.dto.GroupFilter;
import com.trainingvti.entity.Group;
import com.trainingvti.repository.IAccountRepository;
import com.trainingvti.service.IGroupService;

@RestController
@RequestMapping(value = "api/v1/group")
public class GroupController {

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IAccountRepository accountRepository;

	// done
	@GetMapping()
	public Page<?> getGroupAll(Pageable pageable, GroupFilter filter,
			@RequestParam(name = "search", required = false) String search) {

		// get data
		Page<Group> entities = groupService.getGroupAll(pageable, filter, search);

		// convert list entity -> list dto
		Page<GroupDTOOut> dtos = entities.map(new Function<Group, GroupDTOOut>() {
			@Override
			public GroupDTOOut apply(Group entity) {
				GroupDTOOut dto = new GroupDTOOut(entity.getId(), entity.getName(),
						entity.getMember(), (entity.getCreator() == null ? null : entity.getCreator().getUsername()), entity.getCreateDate());
				return dto;
			}
		});

		return dtos;
	}

	// done 	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getGroupId(@PathVariable(name = "id") short id) {
		// declare dto
		GroupDTOOut dto = null;

		// declare entity to fecth data
		Group entity = groupService.getGroupID(id);

		dto = new GroupDTOOut(entity.getId(), entity.getName(),
				entity.getMember(), (entity.getCreator() == null ? null : entity.getCreator().getUsername()), entity.getCreateDate());

		// simply return will work, dont need this
		return new ResponseEntity<GroupDTOOut>(dto, HttpStatus.OK);
	}

	//done
	@GetMapping(value = "name/{name}")
	public ResponseEntity<?> getGroupName(@PathVariable(name = "name") String name) {
		// declare dto
		GroupDTOOut dto = null;

		// declare entity to fecth data
		Group entity = groupService.getGroupName(name);
		if (entity == null) {
			return null;
			
		} else {
			dto = new GroupDTOOut(entity.getId(), entity.getName(),
					entity.getMember(), (entity.getCreator() == null ? null : entity.getCreator().getUsername()), entity.getCreateDate());

			return new ResponseEntity<GroupDTOOut>(dto, HttpStatus.OK);
		}
	}

	// done
	@PostMapping()
	public ResponseEntity<?> createGroup(@RequestBody GroupDTO dto) {

		Group entity = new Group();
		entity.setName(dto.getName());
		entity.setMember(dto.getMember());
		entity.setCreator(dto.getCreator() == null ? null : accountRepository.findById(dto.getCreator()).get());
		groupService.createGroup(entity);

		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateGroup(@PathVariable(name = "id") short id, @RequestBody GroupDTO dto) {

		groupService.updateGroup(id, dto);

		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	// done
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGroup(@PathVariable(name = "id") short id) {
		groupService.deleteGroup(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
	

	@DeleteMapping
	public void deleteGroups(@RequestParam(name = "ids") List<Short> ids) {
		groupService.deleteGroups(ids);
	}
}
