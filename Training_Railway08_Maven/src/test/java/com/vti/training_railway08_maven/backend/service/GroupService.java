package com.vti.training_railway08_maven.backend.service;

import java.sql.SQLException;
import java.util.List;

import com.vti.training_railway08_maven.backend.entity.Group;
import com.vti.training_railway08_maven.backend.repository.GroupRepository;

public class GroupService {
	private GroupRepository repository;

	public GroupService() {
		repository = new GroupRepository();
	}

	public boolean isGroupNameExists(String name) throws ClassNotFoundException, SQLException {
		return repository.isGroupNameExists(name);
	}

	public boolean isGroupIDExists(int id) throws ClassNotFoundException, SQLException {
		return repository.isGroupIDExists(id);
	}
	
	public List<Group> getListGroups() throws ClassNotFoundException, SQLException {
		return repository.getListGroups();
	}

	public Group getGroupID(int id) throws Exception {
		return repository.getGroupID(id);
	}
	
	public void createGroup(String name) throws ClassNotFoundException, SQLException {
		repository.createGroup(name);
	}
	
	public void updateGroup(int id, String newName) throws ClassNotFoundException, SQLException {
		repository.updateGroup(id, newName);
	}
	
	public void deleteGroup(int id) throws ClassNotFoundException, SQLException {
		repository.deleteGroup(id);
	}
}
