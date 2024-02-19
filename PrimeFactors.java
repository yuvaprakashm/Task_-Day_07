/*
 
DAY : 7
ASSIGNMENT NO : 6  
  
Write a method isProductOfPrimeFactors(int posInt) that takes
a positive integer, and return true if the product of all its prime factors
(excluding 1 and the number itself) is equal to its value. For example, the
method returns true for 30 (30=2×3×5) and false for 20 (20?2×5). You
may need to use the isPrime() method in the previous exercise.
Write a program called PerfectPrimeFactorList that prompts the user
for an upper bound. The program shall display all the numbers (less than or
equal to the upper bound) that meets the above criteria. The output shall look
like as given below.


*/
package net.texala.main;

import java.util.Scanner;

public class PrimeFactors {

	public static void main(String[] args) {
		char userinput;
		do {

			System.out.print("Enter the upper bound (positive integer): ");
			Scanner in = new Scanner(System.in);
			if (!in.hasNextInt()) {
				System.out.println("Upper bound not valid. Please try again.");
				return;
			}
			int upperBound = in.nextInt();

			PrimeFactors aPerfectPrimeFactorList = new PrimeFactors();

		

			aPerfectPrimeFactorList.printPerfectPrimeFactors(upperBound);

			System.out.println("Do you want to run again ? (y/n) :");
			userinput = in.next().charAt(0);

		} while (userinput == 'y' || userinput == 'Y');
	}

	private boolean isPrime(int posInt) {
		for (int i = 2; i <= Math.sqrt(posInt); i++) {
			if (posInt % i != 0) {
				continue;
			}
			return false;
		}
		return true;
	}

	private boolean isProductOfPrimeFactors(int posInt) {
		int prod = 1;
		for (int i = 2; i < posInt; i++) {
			if (isPrime(i) && (posInt % i == 0))
				prod = prod * i;
		}
		return (prod == posInt);
	}

	private void printPerfectPrimeFactors(int upperBound) {
		System.out.println("These numbers are equal to the product of prime factors: ");

		int countProductOfPrimeFactors = 0;
		for (int i = 1; i <= upperBound; i++) {
			if (!isProductOfPrimeFactors(i)) {
				continue;
			}
			System.out.printf("%1$d ", i);
			countProductOfPrimeFactors++;
		}
		System.out.printf("\n[%1d numbers found (%2.2f%%)]\n", countProductOfPrimeFactors,
				((double) 100 * countProductOfPrimeFactors / upperBound));
	}

}
