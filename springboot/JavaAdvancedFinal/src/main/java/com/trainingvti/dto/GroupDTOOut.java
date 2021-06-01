package com.trainingvti.dto;

import java.util.Date;

public class GroupDTOOut {
	private short id;
	private String name;
	private int member;
	private String creator;
	private Date createDate;
	
	public GroupDTOOut() {
		super();
	}

	public GroupDTOOut(short id, String name, int member, String creator, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.member = member;
		this.creator = creator;
		this.createDate = createDate;
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

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
