package com.trainingvti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trainingvti.dto.GroupDTO;
import com.trainingvti.dto.GroupFilter;
import com.trainingvti.entity.Group;

public interface IGroupService {
	public Group getGroupID(short id);
	public Group getGroupName(String name);
	public Page<Group> getGroupAll(Pageable pageable, GroupFilter filter, String search);
	public void deleteGroup(short id);
	public void deleteGroups(List<Short> ids);
	public void createGroup(Group department);
	public void updateGroup(short id, GroupDTO dto);
	
}
