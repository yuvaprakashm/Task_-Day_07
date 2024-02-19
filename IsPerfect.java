/*
DAY:07
ASSIGNMENT NO: 04

Write a method called isPerfect(int posInt) that takes a positive
integer, and return the true if the number is perfect. Similarly, write a method
called isDeficient(int posInt) to check for deficient numbers.

*/
package net.texala.main;

import java.util.Scanner;

public class IsPerfect {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			System.out.print("Enter a positive integer: ");
			int number = getUserInput(scanner);

			System.out.println(number + " is perfect: " + isPerfect(number));
			System.out.println(number + " is deficient: " + isDeficient(number));
			System.out.println("Do you want to execute again (y/n) ? :");
			userinput = scanner.next().charAt(0);

		} while (userinput == 'Y' || userinput == 'y');
		scanner.close();
	}

	static int getUserInput(Scanner scanner) {
		int number = -1;
		boolean isValidInput = false;

		while (!isValidInput) {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();

				if (number > 0) {
					isValidInput = true;
				} else {
					System.out.println("Please enter a positive integer greater than 0.");
				}
			} else {
				System.out.println("Invalid input. Please enter a valid positive integer.");
				scanner.next();
			}
		}

		return number;
	}

	static boolean isPerfect(int posInt) {
		if (posInt <= 0) {
			return false;
		}

		int sum = 1;

		for (int i = 2; i <= Math.sqrt(posInt); i++) {
			if (posInt % i == 0) {
				sum += i;
				if (i != posInt / i) {
					sum += posInt / i;
				}
			}
		}

		return sum == posInt;
	}

	static boolean isDeficient(int posInt) {
		if (posInt <= 0) {
			return false;
		}

		int sum = 1;

		for (int i = 2; i <= Math.sqrt(posInt); i++) {
			if (posInt % i == 0) {
				sum += i;
				if (i != posInt / i) {
					sum += posInt / i;
				}
			}
		}

		return sum < posInt;
	}
}
