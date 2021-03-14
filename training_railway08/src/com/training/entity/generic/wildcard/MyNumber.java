package com.training.entity.generic.wildcard;

public class MyNumber<N> {
	private N number;

	public MyNumber(N number) {
		super();
		this.number = number;
	}

	public N getNumber() {
		return number;
	}

	public void setNumber(N number) {
		this.number = number;
	}

}
