package com.vti.training_railway08_maven.backend.controller;

import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.util.StringUtils;
import com.vti.training_railway08_maven.backend.entity.Group;
import com.vti.training_railway08_maven.backend.service.GroupService;

public class GroupController {

	private GroupService groupService;

	public GroupController() {
		groupService = new GroupService();
	}

	public List<Group> getListGroup() throws ClassNotFoundException, SQLException {
		return groupService.getListGroups();
	}

	public Group getGroupID(int id) throws Exception {
		return groupService.getGroupID(id);
	}

	public void createGroup(String name) throws Exception {
		// validate
		if (StringUtils.isNullOrEmpty(name)) {
			throw new Exception("The name must be not empty!");
		}
		if (groupService.isGroupNameExists(name)) {
			throw new Exception("This group name is already exist!");
		}
		// execute
		groupService.createGroup(name);
	}

	public void updateGroup(int id, String newName) throws Exception {
		// validate
		if (groupService.isGroupIDExists(id) == false) {
			throw new Exception("There is no group with this id!");
		}
		// execute
		groupService.updateGroup(id, newName);
	}

	public void deleteGroup(int id) throws Exception {
		// validate
		if (groupService.isGroupIDExists(id) == false) {
			throw new Exception("There is no group with this id!");
		}
		// execute
		groupService.deleteGroup(id);
	}
}
