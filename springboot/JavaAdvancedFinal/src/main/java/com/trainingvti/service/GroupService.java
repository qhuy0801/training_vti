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

import com.trainingvti.dto.GroupDTO;
import com.trainingvti.dto.GroupFilter;
import com.trainingvti.entity.Group;
import com.trainingvti.repository.IAccountRepository;
import com.trainingvti.repository.IGroupRepository;
import com.trainingvti.specification.GroupSpecification;

@Service
public class GroupService implements IGroupService {

	@Autowired
	private IGroupRepository groupRepository;
	
	@Autowired
	private IAccountRepository accountRepository;

	public Group getGroupID(short id) {
		return groupRepository.findById(id).get();
	}
	
	public Group getGroupName(String name) {
		return groupRepository.findByName(name);
	}

	public Page<Group> getGroupAll(Pageable pageable, GroupFilter filter, String search) {
		// specification for searching
		GroupSpecification minIdSpecification = new GroupSpecification("id", ">=", filter.getMinID());

		GroupSpecification maxIdSpecification = new GroupSpecification("id", "<=", filter.getMaxID());

		GroupSpecification searchSpecification = new GroupSpecification("name", "LIKE", search);

		Specification<Group> where = null;

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
		return groupRepository.findAll(where, pageable);
	}
	
	public void updateGroup(short id, GroupDTO dto) {

		Group entity = groupRepository.findById(id).get();

		if (dto.getName() != null) {
			entity.setName(dto.getName());
		}
		
		if (dto.getMember() > 0) {
			entity.setMember(dto.getMember());
		}
		
		if (dto.getCreator() != null) {
			entity.setCreator(accountRepository.findById(dto.getCreator()).get());
		}

		// createDate is not updable
		
		groupRepository.save(entity);
	}

	public void deleteGroup(short id) {
		groupRepository.deleteById(id);
	}
	
	public void deleteGroups(List<Short> ids) {
		groupRepository.deleteByIds(ids);
	}

	public void createGroup(Group group) {
		groupRepository.save(group);
	}
}
