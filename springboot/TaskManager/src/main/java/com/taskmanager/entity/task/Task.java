package com.taskmanager.entity.task;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import com.taskmanager.entity.account.Account;

@Entity
@Table(name = "TaskList", catalog = "TestingSystem")
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "TaskID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "TaskType", nullable = false)
	@Convert(converter = TaskTypeConverter.class)
	private TaskType type;
	
	@ManyToOne
	@JoinColumn(name = "AssignedTo", nullable = false)
	private Account account;
	
	@Column(name = "CreateDate", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	@Column(name = "Deadline", nullable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;
	
	@Column(name = "Status", nullable = false, updatable = true)
	@Convert(converter = StatusConverter.class)
	private Status status;
	
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", type=" + type + ", account=" + account + ", createDate=" + createDate
				+ ", deadline=" + deadline + ", status=" + status + "]";
	}
	
	
}
