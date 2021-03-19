package com.vti.training_railway08_maven.frontend;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vti.training_railway08_maven.backend.controller.GroupController;
import com.vti.training_railway08_maven.backend.entity.Group;

public class Functions {
//	Create pointer
	GroupController groupController = new GroupController();
	Scanner in = new Scanner(System.in);

	public void getListGroup() throws ClassNotFoundException, SQLException {
		// Get list group
		List<Group> getListGroup = groupController.getListGroup();
		for (Group group : getListGroup) {
			System.out.println(group.toString());
		}
	}

	public void getID() throws Exception {
		System.out.println("Please enter group ID to search: ");
		int id = in.nextInt();
		Group group = groupController.getGroupID(id);
		System.out.println(group.toString());
	}

	public void createGroup() throws Exception {
		System.out.println("Please enter the new group name to create: ");
		in.nextLine(); // catch left over line
		String name = in.nextLine();
		groupController.createGroup(name);
	}

	public void updateGroup() throws Exception {
		System.out.println("Please enter group ID to update: ");
		int id1 = in.nextInt();
		System.out.println("Please enter the new name: ");
		in.nextLine();
		String name1 = in.nextLine();
		groupController.updateGroup(id1, name1);
	}

	public void deleteGroup() throws Exception {
		System.out.println("Please enter group ID to delete: ");
		int id2 = in.nextInt();
		groupController.deleteGroup(id2);
	}
}
