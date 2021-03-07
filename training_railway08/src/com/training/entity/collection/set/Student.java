package com.training.entity.collection.set;

public class Student {
	private int id;
	private String name;

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
	if (obj == null) {
		return false;
	}
	
	if (!(obj instanceof Student)) {
		return false;
	}
	
		Student other = (Student) obj;
		if ((this.getId() == other.getId()) && (this.getName().equals(other.getName()))) {
			return true;
		} return false;
	}
	
	// override hashCode compare applied in Set
	public int hashCode() {
        return this.name.hashCode();
    }
}
