package com.training.entity.generic;

public class StaffKV<K, V> extends MyMap<K, V>{

	public StaffKV(K key, V value) {
		super(key, value);
	}

	public K getId() {
		return super.getKey();
	}
	
	public V getName() {
		return super.getValue();
	}
}
