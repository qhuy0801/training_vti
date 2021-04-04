package com.training_vti.java_advanced.entity.testingsystem;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
// table name, database name
@Table(name = "Group", catalog = "TestingSystem")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	// for each column
	// column name and settings
	@Column(name = "name", nullable = false, length = 50, unique = true)
	private String name;

	@Column(name = "author_ID", nullable = true)
	private short author_ID;

	@Column(name = "create_time", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp // for "DEFAULT = NOW()" in mySQK, it will work with TemporalType.TIMESTAMP, not
						// TIME
	private Date create_time;

	public Group() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAuthor_ID() {
		return author_ID;
	}

	public void setAuthor_ID(short author_ID) {
		this.author_ID = author_ID;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", author_ID=" + author_ID + ", create_time=" + create_time + "]";
	}
}
