package com.training.backend.collection.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.training.entity.collection.stackqueue.Student;

public class StudentInterview {
	Stack<Student> student1s;
	Queue<Student> student2s;

	public StudentInterview() {
		student1s = new Stack<>();
		student2s = new LinkedList<>();
	}

	public void sampleData() {
		for (int i = 0; i < 3; i++) {
			student1s.push(new Student("Student " + i));
			student2s.add(new Student("Student " + i));
		}
	}

	public void printStack() {
		int size = student1s.size();
		for (int i = 0; i < size; i++) {
			Student student = student1s.peek();
			System.out.println(student.getName());
			student1s.pop();
		}
	}

	public void printQueue() {
		int size = student2s.size();
		for (int i = 0; i < size; i++) {
			Student student = student2s.peek();
			System.out.println(student.getName());
			student2s.remove(student);
		}
	}
}
