package com.vti.railway08_training.finalAssignment.entity;

public class FresherCandidate extends Candidate {
	private String gradRank;

	public FresherCandidate(String firstName, String lastName, String phone, String email, String gradRank) {
		super(firstName, lastName, phone, email);
		this.gradRank = gradRank;
	}
}
