package com.taskmanager.entity.task;

public enum TaskType {
ADMIN("A"), DEVELOP("D"), OPERATION("O");

	private String code;

	private TaskType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
