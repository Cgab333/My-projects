package q2;

public class ArraySuffixSum {

	public static int computeArraySuffixSum(int[] a, int startIndex) {
		int counter = a.length - startIndex;
		if (counter == 0)
			return 0;

		else {
			counter--;
			return a[startIndex] + computeArraySuffixSum(a, startIndex + 1);
		}
	}

	public static int countArraysWithSuffix(int[][] allArrays, int numOfArrays, int sum) {
		int counter = numOfArrays - 1;
		if (counter == -1)
			return 0;

		else {
			return (computeArraySuffixSum(allArrays[counter], 0) == sum ? +1 : +0)
					+ countArraysWithSuffix(allArrays, numOfArrays - 1, sum);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 6, 10, 2 };

		System.out.println(computeArraySuffixSum(a, 2)); // 12
		System.out.println(computeArraySuffixSum(a, 0)); // 19
		int[][] mat = { { 1, 2, 3, 4 }, { 1, 2, 2, 2 }, { 8, 0, 1 }, { 1, 0, 5 }, { 4, 2, 1, 1 }, { 7, 0 } };
		System.out.println(countArraysWithSuffix(mat, 6, 7));
		//I have notice here is "missmuch" between the result in the test and the actual result;
		//The function works well but countArraysWithSuffix returns 2 which is the real correct answer;
	}

}
