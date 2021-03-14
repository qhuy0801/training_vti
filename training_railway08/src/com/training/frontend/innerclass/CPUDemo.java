package com.training.frontend.innerclass;

import com.training.entity.innerclass.CPU;

public class CPUDemo {
public static void main(String[] args) {
	CPU cpu = new CPU();
	
	CPU.Processor processor = cpu.new Processor();
	CPU.Ram ram = cpu.new Ram();
	
	System.out.println(processor.getCache());
	System.out.println(ram.getClockSpeed());
}
}
