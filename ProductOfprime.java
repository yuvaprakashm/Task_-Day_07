/*

DAY:07
ASSIGNMENT NO:08

Write a method isProductOfPrimeFactors(int posInt) that takes
a positive integer, and return true if the product of all its prime factors
(excluding 1 and the number itself) is equal to its value. For example, the
method returns true for 30 (30=2×3×5) 70(2*5*7) and false for 20 (20?2×5). You
may need to use the isPrime() method in the previous exercise.
*/
package net.texala.main;

import java.util.Scanner;

public class ProductOfprime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char userinput;
		do {
			System.out.print("Enter a positive integer: ");
			int number = getUserInput(scanner);

			System.out.println(number + " is a product of prime factors: " + isProductOfPrimeFactors(number));
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

	static boolean isPrime(int posInt) {
		 
		if (posInt <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(posInt); i++) {
			if (posInt % i == 0) {
				return false;
			}
		}

		return true;
	}

	static boolean isProductOfPrimeFactors(int posInt) {
		if (posInt <= 1) {
			return false;
		}

		int product = 1;

		for (int i = 2; i <= posInt; i++) {
			if (isPrime(i) && posInt % i == 0) {
				product *= i;

				
				}
			}
		

		return product == posInt;
	}

}
