package com.training.entity.collection.set;

public class StudentNameUnique implements Comparable<StudentNameUnique>{
	private int id;
	private String name;

	public StudentNameUnique(int id, String name) {
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

		if (!(obj instanceof StudentNameUnique)) {
			return false;
		}

		StudentNameUnique other = (StudentNameUnique) obj;
		if (this.getName().equals(other.getName())) {
			return true;
		}
		return false;
	}

	// override hashCode compare applied in Set
	public int hashCode() {
		return this.name.hashCode();
	}
	
	// this section is for the sorted set exercise
	@Override
	public int compareTo(StudentNameUnique o) {
		return (this.getName().compareToIgnoreCase(o.getName()));
	}

	@Override
	public String toString() {
		return "StudentNameUnique [id=" + id + ", name=" + name + "]";
	}
}
