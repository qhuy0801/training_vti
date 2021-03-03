package com.training.entity.thissuperoverriding;

public class OldPhone extends Phone {

	@Override
	public void ReceiveCall() {
		System.out.println("Old phone receiving calls...");
	}

	@Override
	public void CallOut() {
		System.out.println("Old phone is calling out...");
	}

	@Override
	public void SendMessages() {
		System.out.println("Old phone is sending text messages...");
	}

	@Override
	public void ReceiveMessages() {
		System.out.println("Old phone is receiving text messages...");
	}

	@Override
	public void Attactk() {
		System.out.println("Attacking... broke enemy head!");
	}
	
	public void Radio() {
		System.out.println("Listening to radio...");
	}

}
