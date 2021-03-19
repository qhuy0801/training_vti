package com.vti.training_railway08_maven.frontend;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws Exception {
//		Scanner in = new Scanner(System.in);
//		Functions func = new Functions();
//
////	Print menu
//		menu();
//
////	Switch to functions
//		while (true) {
//			int i = in.nextInt();
//			switch (i) {
//			case 1:
//				func.getListGroup();
//				break;
//			case 2:
//				func.getID();
//				break;
//			case 3:
//				func.createGroup();
//				break;
//			case 4:
//				func.updateGroup();
//				break;
//			case 5:
//				func.deleteGroup();
//				break;
//			case 6:
//				System.out.println("Quitting...");
//				return;
//			default:
//				System.out.println("There is no matched choice, please try again!");
//				break;
//			}
//		}
		System.out.println("// Looks like a comment.");
	}

	private static void menu() {
		System.out.println("=== Groups ===");
		System.out.println("1. Get groups list");
		System.out.println("2. Get group by ID");
		System.out.println("3. Create group");
		System.out.println("4. Update group");
		System.out.println("5. Delete group");
		System.out.println("6. Quit");
		System.out.println("Please enter the choice:");
	}
}
