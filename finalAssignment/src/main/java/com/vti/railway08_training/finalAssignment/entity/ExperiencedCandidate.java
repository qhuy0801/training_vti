package com.vti.railway08_training.finalAssignment.entity;

public class ExperiencedCandidate extends Candidate {
	private int expInYear;
	private String proSkill;

	public ExperiencedCandidate(String firstName, String lastName, String phone, String email, int expInYear,
			String proSkill) {
		super(firstName, lastName, phone, email);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}
}
