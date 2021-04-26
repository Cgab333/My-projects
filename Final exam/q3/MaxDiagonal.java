package q3;

import java.util.Random;

public class MaxDiagonal {

	private static void randMatrix(int[][] mat) {
		Random r = new Random();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = r.nextInt(10);
			}
		}
	}

	private static void printMatrix(int[][] mat) {
		Random r = new Random();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][][] matrixes = new int[3][4][5];

		for (int i = 0; i < matrixes.length; i++) {
			randMatrix(matrixes[i]);
		}

		int row = 0, col = 1;
		for (int i = 0; i < matrixes.length; i++) {
			printMatrix(matrixes[i]);
			System.out.println(
					"The diagonal sum from [" + row + ", " + col + "] is " + diagonalSum(matrixes[i], row, col));
			System.out.println();
		}

		int max = diagonalComp(matrixes, row, col);
		System.out.println("The max diagonal is from matrix " + max);
	}

	public static int diagonalSum(int[][] mat, int row, int col) {
		int sum = 0;
		for (int currentRow = row, currentCol = col; currentRow <= mat.length && currentCol <= mat.length; currentRow++, currentCol++) {
			sum += mat[currentRow][currentCol];
		}
		return sum;

	}// Line 47 - currentRow= row index at this current loop iteration;
		// currentCol= col index at this current loop iteration;

	private static int diagonalComp(int[][][] listMat, int row, int col) {
		int currentMax = 0;
		for (int index = 0; index < listMat.length; index++) {
			if (diagonalSum(listMat[index], row, col) > diagonalSum(listMat[currentMax], row, col))
				currentMax = index;
		}
		return currentMax;
	}

}
