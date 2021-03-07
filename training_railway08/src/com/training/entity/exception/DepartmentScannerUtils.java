package com.training.entity.exception;

import com.training.entity.utils.ScannerUtils;

public class DepartmentScannerUtils {
	private int id;
	private String name;
	
	ScannerUtils input = new ScannerUtils();
	
	public DepartmentScannerUtils() {
		this.id = input.inputInt("Wrong input format!");
		this.name = input.inputString();
	}

	@Override
	public String toString() {
		return "DepartmentScannerUtils [id=" + id + ", name=" + name + ", input=" + input + "]";
	}

	
}
