package hust.soict.dsai.lab01;

import java.util.Scanner;

public class NumberOfDays {
	public static boolean isValidMonth(String month) {
		String[] validMonths = {"January", "Jan.", "Jan", "1",
								"February", "Feb.", "Feb", "2",
				                "March", "Mar.", "Mar", "3",
				                "April", "Apr.", "Apr", "4",
				                "May", "5",
				                "June", "Jun.", "Jun", "6",
				                "July", "Jul.", "Jul", "7",
				                "August", "Aug.", "Aug", "8",
				                "September", "Sep.", "Sep", "9",
				                "October", "Oct.", "Oct", "10",
				                "November", "Nov.", "Nov", "11",
				                "December", "Dec.", "Dec", "12"};
		
		for (String elements: validMonths) {
			if (month.equalsIgnoreCase(elements)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidYear(int year) {
		return (year >= 1);
	}
	
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String month;
		int year;
		while (true) {
			try {
				System.out.println("Enter the month: ");
				month = sc.nextLine();
				if (isValidMonth(month) == false) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid month! Please enter the month again!");
			}
		}
		while (true) {
			try {
				System.out.println("Enter the year: ");
				year = sc.nextInt();
				if (isValidYear(year) == false) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (Exception e) {
				System.out.println("Invalid year! Please enter the year again!");
			}
		}
		switch (month) {
		case "February": case "Feb.": case "Feb": case "2":
			if (isLeapYear(year)) {
				System.out.println("Number of days: 29");
				break;
			} else {
				System.out.println("Number of days: 28");
				break;
			}
		case "April": case "Apr.": case "Apr": case "4":
		case "June": case "Jun.": case "Jun": case "6":
		case "September": case "Sep.": case "Sep": case "9":
		case "November": case "Nov.": case "Nov": case "11":
			System.out.println("Number of days: 30");
			break;
		default:
			System.out.println("Number of days: 31");
		}
		
	}
}
