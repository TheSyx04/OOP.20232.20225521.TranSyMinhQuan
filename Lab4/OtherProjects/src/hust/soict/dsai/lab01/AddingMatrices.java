package hust.soict.dsai.lab01;

import java.util.Scanner;

public class AddingMatrices {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the matrices \nRows: ");
		int row = sc.nextInt();
		System.out.print("Columns: ");
		int column = sc.nextInt();
		int[][] matrix1 = new int[row][column];
		int[][] matrix2 = new int[row][column];
		int[][] sumMatrix = new int [row][column];
		System.out.println("Enter matrix 1:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix1[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter matrix 2:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix2[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		System.out.println("Sum of 2 matrices:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(sumMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
