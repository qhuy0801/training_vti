package com.training.frontend.abstraction;

import java.util.ArrayList;
import java.util.Scanner;

import com.training.backend.abstraction.MyNews;

public class MyNewsDemo {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	MyNews program = new MyNews();
	
	//	Set up selection program
	while (true) {
		System.out.println("Please enter the program that you want to do: ");
		System.out.println("1. Insert news");
		System.out.println("2. View list news");
		System.out.println("3. Average rate");
		System.out.println("4. Exit");
		System.out.println("Choice: ");
		int i = in.nextInt();
		switch (i) {
		case 1:
			program.InsertNews();
			break;
		case 2:
			program.ViewListNews();
			break;
		case 3:
			// TODO
			break;
		case 4:
			System.out.println("Exiting...4");
			return;
		default:
			System.out.println("Wrong option, please chose again!\n");
			break;
		}
	}
}
}
