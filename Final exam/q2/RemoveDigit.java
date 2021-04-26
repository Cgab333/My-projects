package q2;

import java.util.Arrays;

public class RemoveDigit {

	public static void main(String[] args) {
		System.out.println(removeDigit(123123, 1));
		System.out.println(removeDigit(123123, 2));
		System.out.println(removeDigit(123123, 3));
		System.out.println(removeDigit(123123, 4));

		int arr[] = { 123, 410, 111, 12112, 456, 1 };
		System.out.println(Arrays.toString(arr));
		removeDigitFromArr(arr, arr.length, 1);
		System.out.println(Arrays.toString(arr));

	}

	public static int removeDigit(int num, int digit) {
		if (num == 0) {
			return 0;
		}
		if (num % 10 != digit) {
			return (num % 10) + removeDigit((num / 10), digit) * 10;
		} else
			return removeDigit(num / 10, digit);

	}

	public static void removeDigitFromArr(int[] arr, int length, int digit) {
		for (int index = 0; index < arr.length; index++) {
			arr[index] = removeDigit(arr[index], digit);
		}
	}
}
