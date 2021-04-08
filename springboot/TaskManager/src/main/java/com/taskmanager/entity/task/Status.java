package com.taskmanager.entity.task;

public enum Status {
	PENDING("P"), APPROVED("A"), REJECTED("R");

	private String code;

	private Status(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
