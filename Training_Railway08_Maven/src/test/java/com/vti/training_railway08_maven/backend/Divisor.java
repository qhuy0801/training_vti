package com.vti.training_railway08_maven.backend;

import java.util.Scanner;

public class Divisor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
				if (i != (n / i)) {
					System.out.print((n / i) + " ");
				}
			}
		}
	}
}
