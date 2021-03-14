package com.training.entity.generic;

public class PhoneKV<K, V> extends MyMap<K, V>{

	public PhoneKV(K key, V value) {
		super(key, value);
	}
	
	public V getPhoneNumber() {
		return super.getValue();
	}
}
