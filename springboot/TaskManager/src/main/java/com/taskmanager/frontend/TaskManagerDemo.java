package com.taskmanager.frontend;

import java.util.List;

import com.taskmanager.entity.task.Task;
import com.taskmanager.repository.TaskRepository;

public class TaskManagerDemo {
	public static void main(String[] args) {
		TaskRepository repo = new TaskRepository();

		List<Task> tasks = repo.getTaskAll();
		
		for (Task task : tasks) {
			System.out.println(task.toString());
		}
	}
}
