package com.training.entity.thissuperoverriding;

public abstract class Phone implements PhoneInterface{
	public abstract void ReceiveCall();
	public abstract void CallOut();
	public abstract void SendMessages();
	public abstract void ReceiveMessages();
}
