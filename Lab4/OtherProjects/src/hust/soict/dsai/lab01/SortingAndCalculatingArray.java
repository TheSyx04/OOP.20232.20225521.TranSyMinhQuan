package hust.soict.dsai.lab01;

import java.util.Scanner;

public class SortingAndCalculatingArray {
    public static void insertionSort(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
	public static double sumArray(double A[]) {
		double sum = 0;
		for (double i: A) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		System.out.print("Enter the element of array: ");
		double[] array = new double[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextDouble();
		}
		insertionSort(array);
		for (double i: array) {
			System.out.print(i + "\t");
		}
		double sum = sumArray(array);
		double average = sum / n;
		System.out.println("\nThe sum is " + sum);
		System.out.println("The average value is " + average);
	}
}
