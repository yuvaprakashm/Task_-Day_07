/*

DAY : 7
ASSIGNMENT NO : 7



*/

//primeList

package net.texala.main;

import java.util.Scanner;

public class IsPrime {

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

			IsPrime aPrimeList = new IsPrime();
			aPrimeList.printPrimes(upperBound);
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

	private void printPrimes(int upperBound) {
		int countPrimes = 0;
		for (int i = 1; i <= upperBound; i++) {
			if (!isPrime(i)) {
				continue;
			}
			System.out.println(i);
			countPrimes++;
		}
		System.out.printf("\n[%1d primes found (%2.2f%%)]\n", countPrimes, ((double) 100 * countPrimes / upperBound));
	}

}
