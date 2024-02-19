/*
  
 DAY : 7
 ASSIGNMENT NO : 1 
  
Write a program called NumberGuess to play the number guessing game.
The program should generate a random number between 0 to 99. The player
inputs her/his guess and the program shall respond with Try higher, Try
lower or You got it in n trials accordingly. For example,
> Java NumberGuess
Key in your guess:
50
Try higher
70
Try lower
65
Try lower
"
You got it in 4 trials!

*/
package net.texala.main;

import java.util.Scanner;

public class NumberGuess {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int secretNumber = (int) (Math.random() * 100);
		int guess;
		int trails = 0;
		char userinput;

		System.out.println("Welcome to number guessing game ! ");
		System.out.println("Please enter a number between 1 to 99 : ");
		do {

			do {
				System.out.println("Enter your guess :");
				while (true) {
					try {
						guess = Integer.parseInt(scr.nextLine());
						if (guess >= 1 && guess <= 99) {
							break;
						} else {
							System.out.println("Please enter a number between 1 and 99.");
						}
						
					} catch (NumberFormatException e) {
						System.out.println("Invalid input. Please enter a valid number.");
					}
				}
				trails++;
				if (guess < secretNumber) {
					System.out.println("Try Higher Number");
				} else if (guess > secretNumber) {
					System.out.println("Try Lower Number");
				} else {
					System.out.println("You got it in " + trails + " trails !");
				}
			} while (guess != secretNumber);

			System.out.println("Do you want to run again ? (y/n) :");
			userinput = scr.next().charAt(0);
			scr.nextLine();

		} while (userinput == 'y' || userinput == 'Y');

	}
}