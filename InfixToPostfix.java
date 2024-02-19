/*


DAY : 7
ASSIGNMENT NO : 9


Write a Java program to convert a given infix expression into postfix by
using stack. You can see the algorithm in the image

I/P: 
(A+B)/B+(C+D)*E-F


*/
package net.texala.main;

import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfix {

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static int getPrecedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}

	public static String infixToPostfixConversion(String infixExpression) {
		StringBuilder postfixExpression = new StringBuilder();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < infixExpression.length(); i++) {
			char ch = infixExpression.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				postfixExpression.append(ch);
			} else if (ch == '(') {
				operatorStack.push(ch);
			} else if (ch == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					postfixExpression.append(operatorStack.pop());
				}
				operatorStack.pop();
			} else if (isOperator(ch)) {
				while (!operatorStack.isEmpty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())) {
					postfixExpression.append(operatorStack.pop());
				}
				operatorStack.push(ch);
			}
		}

		while (!operatorStack.isEmpty()) {
			postfixExpression.append(operatorStack.pop());
		}

		return postfixExpression.toString();
	}

	public static void main(String[] args) {

		char userinput;
		InfixToPostfix converter = new InfixToPostfix();

		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the InfixExpression : ");
			String infixExpression = sc.nextLine();

			String postfixExpression = converter.infixToPostfixConversion(infixExpression);

			System.out.println("Infix Expression: " + infixExpression);
			System.out.println("Postfix Expression: " + postfixExpression);
			System.out.println("Do you want to execute again ? (y/n) :");
			userinput = sc.next().charAt(0);
		} while (userinput == 'y' || userinput == 'Y');
	}
}
