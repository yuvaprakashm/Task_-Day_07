/*

DAY : 7
ASSIGNMENT NO : 7 

One of the earlier known algorithms is the
Euclid algorithm to find the GCD of two integers (developed by the Greek
Mathematician Euclid around 300BC). By definition, GCD (a, b) is the greatest factor
that divides both a and b. Assume that a and b are positive integers, and a?b, the
Euclid algorithm is based mainly on these two properties

*/
package net.texala.main;

import java.util.Scanner;

public class Gcd {
	public static void main(String[] args) {
		char userinput;
		do {
			Scanner scanner = new Scanner(System.in);
			Gcd aGCD = new Gcd();

			System.out.print("Enter the first number: ");
			int num1 = scanner.nextInt();

			System.out.print("Enter the second number: ");
			int num2 = scanner.nextInt();

			System.out.println("GCD using iteration: " + aGCD.gcd(num1, num2));

			System.out.println("GCD using recursion: " + aGCD.gcdRecursive(num1, num2));

			System.out.println("Do you want to execute again ? (y/n) :");
			userinput = scanner.next().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');
	}

	private int gcd(int a, int b) { // iteration
		if (b == 0) {
			return a;
		}

		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}

		return a;
	}

	private int gcdRecursive(int a, int b) { // recursion
		if (b == 0) {
			return a;
		} else {
			int a1 = b;
			int b1 = a % b;
			return gcdRecursive(a1, b1);
		}
	}
}
