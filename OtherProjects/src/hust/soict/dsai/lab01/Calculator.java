package hust.soict.dsai.lab01;

import java.util.Scanner;

public class Calculator {
	public static boolean isZero(double value, double epsilon) {
		return value >= - epsilon && value <= epsilon; 
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		double num1 = sc.nextDouble();
		System.out.println("Enter the second number");
		double num2 = sc.nextDouble();
		System.out.println("The following results are displayed with 5 decimal digits.");
		double sum = num1 + num2;
		System.out.printf("Sum: %.5f \n", sum);
		double difference = num1 - num2;
		System.out.printf("Difference: %.5f \n", difference);
		double product = num1 * num2;
		System.out.printf("Product: %.5f \n", product);
		if (isZero(num2, 1e-6)) {
			System.out.println("Invalid divisor, can't calculate the quotient!");
		} else {
			double quotient = num1 / num2;
			System.out.printf("Quotient: %.5f \n", quotient);
		}
	}
}
