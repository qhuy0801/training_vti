package com.training_vti.java_advanced.frontend;

import java.util.List;
import java.util.Scanner;

import com.training_vti.java_advanced.backend.repository.testingsystem_abc.GroupRepository;
import com.training_vti.java_advanced.entity.testingsystem_abc.Group;

public class GroupCRUDDemo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GroupRepository repository = new GroupRepository();

		// Create
//		System.out.print(" Enter the name of the new group here: ");
//		String name = in.nextLine();
//		System.out.println("\nEnter the author ID: ");
//		short authorID = in.nextShort();
//		repository.createGroup(name, authorID);

		// Read
		List<Group> groups = repository.getGroupAll();
		for (Group group : groups) {
			System.out.println(group.toString());
		}

		// Read - get by ID
//		System.out.print("\nPlease enter the ID that you want to search: ");
//		short id = in.nextShort();
//		System.out.println(repository.getGroupID(id).toString());
		
		// Read - get by name
//		System.out.print("\nPlease enter the name that you want to search: ");
//		String name = in.nextLine();
//		System.out.println(repository.getGroupName(name).toString());

		// Update - id, newName
//		System.out.print("\nPlease enter the ID that you want to search: ");
//		short id = in.nextShort();
//		System.out.print("\nEnter the new name of the new group here: ");
//		in.nextLine();
//		String newName = in.nextLine();
//		repository.updateGroupName(id, newName);
		
		// Update - group as an object
		// Initialize group object
		// Currently this is not working
//		Group group = repository.getGroupID((short)5);
//		group.setName("JS fresher");
//		repository.updateGroup(group);
		
		// Delete
//		System.out.print("\nPlease enter the ID that you want to delete: ");
//		short id = in.nextShort();
//		repository.deleteGroup(id);
		
	}
}
