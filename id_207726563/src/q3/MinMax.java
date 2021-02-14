package q3;

public class MinMax {
	public static void printMatrix(int[][] mat) {

		for (int[] line : mat) {
			System.out.print(" ");
			for (int num : line) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	private static boolean isMinMaxElement(int[][] matrix, int row, int col) {

		if ((row == 0 || row == matrix.length) && col == 0 || col == matrix.length) {
			return false;
		}
		for (int index = (row == 0 ? 0 : row - 1), counter = (col == 0 ? 0 : col - 1); counter < col + 1; counter++) {
			if (matrix[row][col] >= matrix[index][counter]) {
				continue;
			} else
				return false;
		}
		for (int index = (row == matrix.length - 1 ? matrix.length - 1 : row + 1), counter = (col == 0 ? 0
				: col - 1); counter < col + 1; counter++) {
			if (matrix[row][col] >= matrix[index][counter]) {
				continue;
			} else
				return false;
		}
		if ((matrix[(row == 0 ? 0 : row - 1)][(col == matrix.length - 1 ? matrix.length - 1
				: col + 1)] < matrix[(row == 0 ? 0 : row - 1)][(col == 0 ? 0 : col - 1)]
				|| matrix[(row == 0 ? 0 : row - 1)][(col == matrix.length - 1 ? matrix.length - 1
						: col + 1)] < matrix[(row == 0 ? 0 : row - 1)][(col == matrix.length - 1 ? matrix.length - 1
								: col + 1)])) {
			return false;
		} else
			return true;

	}// Check if the matrix have a (min-max) value.

	public static void checkMinMaxMatrix(int[][] matrix) {
		int max = 0;
		int correntMax = 0;
		int counter = 0;
		for (int index = 0; index < matrix.length; index++) {
			for (int col = 0; col < matrix.length; col++) {
				if (isMinMaxElement(matrix, index, col)) {
					correntMax = matrix[index][col];
					counter++;
					if (correntMax < max) {
						max = correntMax;
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 4, 3, 7 }, { 1, 9, 1, 5, 6 }, { 0, 1, 2, 8, 3 }, { 1, 5, 6, 7, 8 },
				{ 1, 2, 1, 1, 1 } };
		System.out.println(isMinMaxElement(matrix, 2, 3));
		checkMinMaxMatrix(matrix);

	}

}
