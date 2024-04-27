package hust.soict.dsai.lab01;

import java.util.Scanner;

public class BetterCalculator {
	public static boolean isZero(double value, double epsilon) {
		return value >= - epsilon && value <= epsilon; 
	}
	
	public static void firstDegreeEquation(double a, double b) {
		if (isZero(a, 1e-6)) {
			if (isZero(b, 1e-6)) {
				System.out.println("The equation has infinitely many solutions");
			} else {
				System.out.println("The equation has no solution");
			}
		} else {
			double x = -b / a;
			System.out.println("The system has only one solution: x = " + x);
		}
	}
	
	public static void firstDegreeEquation(double a11, double a12, double b1, double a21, double a22, double b2) {
		double D = a11 * a22 - a21 * a12;
		double D1 = b1 * a22 - b2 * a12;
		double D2 = a11 * b2 - a21 * b1;
		if (isZero(D, 1e-6)) {
			if (isZero(D1, 1e-6)) {
				System.out.println("The system has infinitely many solutions");
			} else {
				System.out.println("The system has no solution");
			}
		} else {
			double x1 = D1 / D;
			double x2 = D2 / D;
			System.out.println("The system has only one solution: x1 = " + x1 + ", x2 = " + x2);
		}
	}
	
	public static void secondDegreeEquation(double a, double b, double c) {
		if (a == 0) {
			firstDegreeEquation(b, c);
		} else {
			double delta = b*b - 4*a*c;
			if (delta < 0) {
				System.out.println("The system has no real solutions");
			} else if (isZero(delta, 1e-6)) {
				double x = -b / 2 / a;
				System.out.println("The system has only one solution: x = " + x);
			} else {
				double x1 = (Math.sqrt(delta) - b) / 2 / a;
				double x2 = -(Math.sqrt(delta) + b) / 2 / a;
				System.out.println("The system has 2 solutions: x1 = " + x1 + ", x2 = " + x2);
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose mode: \n1. Linear equation with one variable."
							+ "\n2. Linear system with two variables."
							+ "\n3. Second order equation with one variable.");
		int mode = sc.nextInt();
		if (mode == 1) {
			System.out.println("Enter the coefficients of the equation: ax + b = 0");
			System.out.print("a = ");
			double a = sc.nextDouble();
			System.out.print("b = ");
			double b = sc.nextDouble();
			firstDegreeEquation(a, b);
		} else if (mode == 2) {
			System.out.println("Enter the coefficients of the first equation: a11*x1 + a12*x2 = b1" );
			System.out.print("a11 = ");
			double a11 = sc.nextDouble();
			System.out.print("a12 = ");
			double a12 = sc.nextDouble();
			System.out.print("b1 = ");
			double b1 = sc.nextDouble();
			System.out.println("Enter the coefficients of the second equation: a21*x1 + a22*x2 = b2");
			System.out.print("a21 = ");
			double a21 = sc.nextDouble();
			System.out.print("a22 = ");
			double a22 = sc.nextDouble();
			System.out.print("b2 = ");
			double b2 = sc.nextDouble();
			firstDegreeEquation(a11, a12, b1, a21, a22, b2);
		} else if (mode == 3){
			System.out.println("Enter the coefficient of the equation: ax^2 + bx + c = 0");
			System.out.print("a = ");
			double a = sc.nextDouble();
			System.out.print("b = ");
			double b = sc.nextDouble();
			System.out.print("c = ");
			double c = sc.nextDouble();
			secondDegreeEquation(a, b, c);
		} else {
			System.out.println("Invalid mode!");
		}
	}
}
