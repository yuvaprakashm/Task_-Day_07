/*

DAY : 7
ASSIGNMENT NO : 8

Write a function named operationOnExpression () which performs
the operation on it.
For example, If MATHS.TXT contains the result of 2 + 4 * 3 = 14, and result of
16 / 2 + 1 = 9.
Print the symbols exactly in the way they were read.
+ , * , = , / , +, =

*/
package net.texala.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Expression {

	public static void operationOnExpression(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				evaluateExpression(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void evaluateExpression(String expression) {
		Stack<Integer> numbers = new Stack<>();
		Stack<Character> operators = new Stack<>();

		StringBuilder currentNumber = new StringBuilder();

		for (char ch : expression.toCharArray()) {
			if (Character.isDigit(ch)) {
				currentNumber.append(ch);
			} else if (isOperator(ch)) {
				if (currentNumber.length() > 0) {
					numbers.push(Integer.parseInt(currentNumber.toString()));
					currentNumber.setLength(0);
				}
				operators.push(ch);
			} else if (ch == '=') {
				if (currentNumber.length() > 0) {
					numbers.push(Integer.parseInt(currentNumber.toString()));
					currentNumber.setLength(0);
				}
				performOperations(numbers, operators);
			}
		}

		for (char ch : expression.toCharArray()) {
			if (isOperator(ch) || ch == '=') {
				System.out.print(ch + " ");
			}
		}

		System.out.println();
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static void performOperations(Stack<Integer> numbers, Stack<Character> operators) {
		while (!operators.isEmpty() && operators.peek() != '=') {
			char operator = operators.pop();
			int operand2 = numbers.pop();
			int operand1 = numbers.pop();
			int result = performOperation(operand1, operand2, operator);
			numbers.push(result);
		}

		if (!operators.isEmpty() && operators.peek() == '=') {
			operators.pop();
		}
	}

	private static int performOperation(int operand1, int operand2, char operator) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException("Unsupported operator: " + operator);
		}
	}

	public static void main(String[] args) {

		String fileName = "maths.txt";
		operationOnExpression(fileName);
	}
}
