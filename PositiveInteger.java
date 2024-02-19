/*

DAY : 7
ASSIGNMENT NO : 4

positive integer is called a perfect
number if the sum of all its factors (excluding the number itself, that is, proper
divisor) is equal to its value. For example, the number 6 is perfect because its
proper divisors are 1, 2, and 3, and 6=1+2+3; but the number 10 is not perfect
because its proper divisors are 1, 2, and 5, and 10?1+2+5.
		
*/
package net.texala.main;

import java.util.Scanner;

public class PositiveInteger {

	public static void main(String[] args) {
		char userinput;

		PositiveInteger aNumberTheoryUtil = new PositiveInteger();
		do {
			System.out.print("Enter the upper bound (positive integer): ");

			Scanner in = new Scanner(System.in);

			if (!in.hasNextInt()) {
				System.out.println("Upper bound not valid. Please try again.");
				return;
			}
			int upperBound = in.nextInt();

			if (upperBound < 0) {
				System.out.println("Upper bound is not positive. Please try again.");
				return;
			}

			System.out.println("These numbers are perfect:");
			int countPerfectNumbers = 0;
			for (int i = 1; i <= upperBound; i++) {
				if (!aNumberTheoryUtil.isPerfect(i)) {
					continue;
				}
				System.out.printf("%d ", i);
				countPerfectNumbers++;
			}
			System.out.printf("\n[%d perfect numbers found (%2.2f%%)]\n", countPerfectNumbers,
					((double) 100 * countPerfectNumbers / upperBound));

			System.out.println();

			System.out.println("These numbers are neither deficient nor perfect:");
			int countDeficientNumbers = 0;
			for (int i = 1; i <= upperBound; i++) {
				if (aNumberTheoryUtil.isDeficient(i) || aNumberTheoryUtil.isPerfect(i)) {
					continue;
				}
				System.out.printf("%d ", i);
				countDeficientNumbers++;
			}
			System.out.printf("\n[%1d numbers found (%2.2f%%)]\n", countDeficientNumbers,
					((double) 100 * countDeficientNumbers / upperBound));
			System.out.println("Do you want to run again ? (y/n) :");
			userinput = in.next().charAt(0);

		} while (userinput == 'y' || userinput == 'Y');
	}

	private boolean isPerfect(int posInt) {
		int sumDivisors = 0;
		for (int i = 1; i < posInt; i++) {
			if (posInt % i == 0) {
				sumDivisors += i;
			}
		}
		return (sumDivisors == posInt);
	}

	private boolean isDeficient(int posInt) {
		int sumDivisors = 0;
		for (int i = 1; i < posInt; i++) {
			if (posInt % i == 0) {
				sumDivisors += i;
			}
		}
		return (sumDivisors < posInt);
	}
}
