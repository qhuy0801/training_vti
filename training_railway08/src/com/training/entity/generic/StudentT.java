package com.training.entity.generic;

public class StudentT<T> {
	private T id;
	private String name;

	public StudentT(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public void printStudent() {
		
	}
}
