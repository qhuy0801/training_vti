package com.training.entity.thissuperoverriding;

public class ModernPhone extends Phone {

	@Override
	public void ReceiveCall() {
		System.out.println("Modern phone receiving calls...");
	}

	@Override
	public void CallOut() {
		System.out.println("Modern phone is calling out...");
	}

	@Override
	public void SendMessages() {
		System.out.println("Modern phone is sending text messages...");
	}

	@Override
	public void ReceiveMessages() {
		System.out.println("Modern phone is receiving text messages...");
	}

	@Override
	public void Attactk() {
		System.out.println("Attacking... broke the screen!");
	}
	
	public void UseInternet() {
		System.out.println("Using the internet...");
	}
	
	public void TakePhotos() {
		System.out.println("Taking photos...");
	}

}
