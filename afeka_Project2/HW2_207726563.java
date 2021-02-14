package afeka_Project2;

import java.util.Arrays;
import java.util.Scanner;

public class HW2_207726563 {

	/*
	 * Name:Shay Gabison ID:207726563 HomeWorkNumber:2
	 *
	 * Menu of 9 option representing by switch. every case have a Detailed
	 * documentation. Enjoy.
	 *
	 */

	public static void main(String[] args) {
		int menuChoice;
		int counter = 0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please select an option:\r\n" + "1 - 'Pascal's' array  (5.3)\r\n"
					+ "2 - Is the value indented?  (5.5)\r\n" + "3 - Increase intermediate letters (5.6)\r\n"
					+ "4 - Check if two arrays[Are the same] (5.7)\r\n" + "5 - A mirror pair (5.8)\r\n"
					+ "6 - Array represent by asterisk (5.11)\r\n"
					+ "7 - Check if row sum and col sum in matrix are equal (6.6)\r\n"
					+ "8 – Long numbers (int) represent by array (6.8)\r\n" + "9 - Exit\r\n" + "\r\n" + " ");
			System.out.println("enter one number : ");
			menuChoice = input.nextInt();
			switch (menuChoice) {
			case (1):
				/*
				 * In this case the program defines an array of size 10 and gets values ​​for
				 * the first 2 indexes. The value of each follow index will be the sum of the
				 * two indexes before it. 
				 * The variables in this case are: 
				 * arrayCase1 = array size 10.
				 *  i and k = locals variables representing the index.
				 */
				int[] arrayCase1 = new int[10];
				for (int i = 0; i < 2; i++) {
					System.out.printf("Please enter a number for the index  %d: %n", i + 1);
					arrayCase1[i] = input.nextInt();
				}
				for (int k = 2; k < 10; k++) {
					arrayCase1[k] = (arrayCase1[k - 1] + arrayCase1[k - 2]);
				}

				System.out.println(Arrays.toString(arrayCase1));

				break;
			case (2):
				/*
				 * In this case the program receives values ​​for two arrays of the same size.
				 * The program will display whether the values ​​of the first array identical to second but with a intended of one index to the right. 
				 * The variables in this case are: 
				 * array1Case2=array size 5. 
				 * array2Case2=array size 5. 
				 * result1=boolean value.
				 * checkIndex=representing the index we checking.
				 *  i = local variable representing the index when the program receives the values .
				 */
				int[] array1Case2 = new int[5];
				int[] array2Case2 = new int[5];
				boolean result1;
				int checkIndex = 0;
				for (int i = 0; i < array1Case2.length; i++) {
					System.out.println("Please enter a number for the first array: ");
					array1Case2[i] = input.nextInt();
				}
				for (int i = 0; i < array2Case2.length; i++) {
					System.out.println("Please enter a number for the secound array: ");
					array2Case2[i] = input.nextInt();
				}
				for (checkIndex = 0; (checkIndex < array1Case2.length - 1); checkIndex++) {
					if (array1Case2[checkIndex] == array2Case2[checkIndex + 1])
						continue;
					else {
						if (checkIndex == array1Case2.length) {
							if (array1Case2[checkIndex] == array2Case2[0]) {
								checkIndex = array1Case2.length;
							} else
								break;
						} else
							break;

					}
				}
				result1 = ((checkIndex == array1Case2.length - 1));
				System.out.println(result1);

				break;

			case (3):

				/*
				 * In this case the program receives chars values ​​for array size 10. 
				 * It is known that this array has 2 capital letters exactly, the rest lowercase. 
				 * The program replace all the letters in this range with uppercase letters. 
				 * The variables in this case are: 
				 * arrayCase3=array size 10. 
				 * i = local variable representing the index .
				 * counter = int - represent the 2 capital letters count.
				 */

				char[] arrayCase3 = new char[10];
				for (int i = 0; i < 10; i++) {
					System.out.println("Please enter a char: ");
					arrayCase3[i] = input.next().charAt(0);
				}
				for (int i = 0; i < 10; i++) {
					if (counter == 1 && (arrayCase3[i] >= 'a' && arrayCase3[i] <= 'z')) {
						arrayCase3[i] = (char) (arrayCase3[i] - 32);
					} else if (arrayCase3[i] >= 'A' && arrayCase3[i] <= 'Z') {
						counter++;
					}
					if (counter == 2) {
						break;
					}

				}
				System.out.println(arrayCase3);

				break;
			case (4):
				/*
				 * In this case The program Set up 3 arrays in size 5 and receives into two of them values ​​from the user. 
				 * The values ​​must be sorted by smallest grow.
				 * The program copy to the third set each value Which appears in both the first array and the second array. 
				 * Finally print the third array as well as the number of values sit.
				 * The variables in this case are: 
				 * array1Case4 = array size 5. 
				 * array2Case4 = array size 5.
				 * array3Case4 = array size 5. 
				 * i= local variable representing the index . 
				 * counter= int - represent the number of values sit.
				 */
				counter = 0;
				int[] array1Case4 = new int[5];
				int[] array2Case4 = new int[5];
				int[] array3Case4 = new int[5];
				for (int i = 0; i < 5; i++) {
					System.out.println("Please enter a number for array #1 in lenght of 5: ");
					array1Case4[i] = input.nextInt();
				}
				for (int i = 0; i < 5; i++) {
					System.out.println("Please enter a number for array #2 in lenght of 5: ");
					array2Case4[i] = input.nextInt();
				}

				for (int i = 0; i < 5; i++) {
					for (int k = 0; k < 5; k++) {
						if (array2Case4[i] == array1Case4[k]) {
							array3Case4[i] += array2Case4[i];
							counter += 1;
						}
					}
				}
				System.out.println(Arrays.toString(array3Case4) + "\n the number of items in this array is:" + counter);

				break;
			case (5):
				/*
				 * A pair of numbers will be called a "mirror pair" if their numerical order is
				 * reversed, they have the same number of digits as well as provided That both
				 * numbers are positive. 
				 * An array is called a "mirror array" if each pair of
				 * values ​​from the beginning and end are a "mirror pair".
				 * 
				 * In this case the program defines an array in the size of an even SIZE (for
				 * example 6) and receives numbers into it. 
				 * The program will display a message Suitable whether the array is a "mirror arrays". 
				 * The variables in this case are: 
				 * sizeOfTheArray= even number represent the size of the array. 
				 * arrayCase5= array size of (sizeOfTheArray).
				 * index and k = locals variables representing the index.
				 */
				System.out.println("Please enter an even number for the size of the array: ");
				int sizeOfTheArray = input.nextInt();
				int[] arrayCase5 = new int[sizeOfTheArray];
				int index = 0;
				for (int k = 0; k < sizeOfTheArray; k++) {
					System.out.println("Please enter a number for array in lenght of " + sizeOfTheArray + ": ");
					arrayCase5[k] = input.nextInt();
				}
				for (; index < sizeOfTheArray / 2; index++) {
					if (arrayCase5[index] != replace(arrayCase5[(sizeOfTheArray - index - 1)])) {
						System.out.println("Not a mirror pair array");
						break;
					}
				}
				if (index == sizeOfTheArray / 2) {
					System.out.println("A mirror pair array");
				}

				break;
			case (6):
				/*
				 * In this case the program receives 4 numbers (between 1-10) into an array. 
				 * The program display each value in the array so that there will be a column with
				 * the value at the bottom and asterisks above it as an entry. 
				 * The variables in this case are: 
				 * checkInput= Range test for values. 
				 * arrayCase6 = array size 4.
				 * maximumValue= int that gets the maximum value of the array.
				 * staticMaximumValue= same as maximumValue but stay static.
				 *  i and k = locals variables representing the index.
				 */
				int checkInput;
				int[] arrayCase6 = new int[4];
				for (int i = 0; i < 4; i++) {
					System.out.println("Please enter a number between 1-10: ");
					checkInput = input.nextInt();
					if (checkInput > 9) {
						System.out.println("Error please enter a number between 1-10!:");
						while (checkInput > 9) {
							System.out.println("Please enter a number between 1-10: ");
							checkInput = input.nextInt();
							if (checkInput > 9) {
								System.out.println("Error please enter a number between 1-10!:");
							} else
								arrayCase6[i] = checkInput;
						}
					} else
						arrayCase6[i] = checkInput;
				}
				int maximumValue = maximumValue(arrayCase6);
				int staticMaximumValue = maximumValue;
				for (int k = 0; k < staticMaximumValue; k++) {
					for (int i = 0; i < 4; i++) {
						if (arrayCase6[i] < maximumValue)
							System.out.print("   ");
						else {
							System.out.print("*  ");
						}
					}
					maximumValue -= 1;

					System.out.println();

				}
				System.out.println("------------");

				for (int i = 0; i < 4; i++) {
					System.out.print(arrayCase6[i] + "  ");
				}

				break;

			case (7):
				/*
				 * In this case a function that receives a quadratic matrix The function returns
				 * TRUE if the sum of the values in each row is equal to the sum of the values
				 * in the corresponding column, and returns FALSE otherwise 
				 *The variables in this case are: 
				 *rowAndColLenght= The quadratic matrix size.
				 * matrixCase7=quadratic matrix size of (rowAndColLenght).
				 *  i and k = locals variables representing the index.
				 */
				System.out.println("Please enter a number for the quadratic matrix size: ");
				int rowAndColLenght = input.nextInt();
				int[][] matrixCase7 = new int[rowAndColLenght][rowAndColLenght];
				for (int i = 0; i < rowAndColLenght; i++) {

					for (int k = i; k < rowAndColLenght; k++) {

						System.out.println(" Please enter a number for item in:" + (i + 1) + " , " + (k + 1));
						matrixCase7[i][k] = input.nextInt();
						if (k != i) {
							System.out.println("Please enter a number for item in:" + (k + 1) + " , " + (i + 1));
							matrixCase7[k][i] = input.nextInt();
						}
					}

				}
				System.out.println(matrixSum(matrixCase7, rowAndColLenght));
				break;

			case 8:
				/*
				 * In this case a function gets 2 arrays each representing a number as defined above. 
				 * The function create and return a new array that represents the number
				 * which is the sum of the values ​​of the 2 numbers obtained. 
				 * The variables in this case are: 
				 * lenghtArray1Case8= first array length. 
				 * lenghtArray2Case8=second array length. 
				 * Array1Case8=array size (lenghtArray1Case8).
				 * Array2Case8=array size (lenghtArray2Case8). 
				 * i = local variable representing the index.
				 */
				System.out.println("Please enter a number for the first array length: ");
				int lenghtArray1Case8 = input.nextInt();
				int[] Array1Case8 = new int[lenghtArray1Case8];
				System.out.println("Please enter a number for the second array length: ");
				int lenghtArray2Case8 = input.nextInt();
				int[] Array2Case8 = new int[lenghtArray2Case8];
				for (int i = 0; i < Array1Case8.length; i++) {
					System.out.println("Please enter a number for the first array: ");
					Array1Case8[i] = input.nextInt();
				}
				for (int i = 0; i < Array2Case8.length; i++) {
					System.out.println("Please enter a number for the secound array: ");
					Array2Case8[i] = input.nextInt();
				}

				System.out.println(Arrays.toString(add(Array1Case8, Array2Case8)));

				break;
			case (9):
				/*
				 * Menu exit.
				 */
				System.out.println("You chose exit");
				break;
			default:
				/*
				 * The default in this switch print to the user "Invalid input".
				 */
				System.out.println("Invalid input");
				break;
			}
		} while (menuChoice != 9);
	}

//Function for checking pair numbers by replacing their digits place.
	public static int replace(int num) {
		int counter = 0;
		int temp = num;
		int sum = 0;
		while (num != 0) {
			num /= 10;
			counter++;

		}
		counter = (int) Math.pow(10, counter - 1);
		while (temp != 0) {
			sum = sum + (temp % 10) * counter;
			counter /= 10;
			temp /= 10;

		}
		return sum;
	}

//Function that return the maximum value of an array.
	public static int maximumValue(int[] array) {
		int checkMax = 0;
		for (int index = 0; index < ((array.length) - 1); index++) {
			if (array[index] > array[index + 1]) {
				checkMax = array[index];
			} else {
				checkMax = array[index + 1];
			}

		}
		return checkMax;

	}

	// documentation in case 7.
	public static boolean matrixSum(int mat[][], int a) {
		int b = 0;
		for (int i = 0; i < a; i++) {
			int row = 0, col = 0;
			for (int k = 0; k < a; k++) {
				row += mat[i][k];
				col += mat[k][i];
			}
			if (col == row) {
				b++;
				continue;
			} else
				break;

		}

		return b == a ? true : false;
	}
	// documentation in case 8.

	public static int[] add(int mat[], int mat2[]) {

		int sumOfMat = 0;
		int sumOfMat2 = 0;
		int resultOfSum = 0;
		int digitPlace = 1;
		int digitPlace2 = 1;
		int counter = 0;
		for (int index = mat.length - 1; index >= 0; index--) {
			sumOfMat += (mat[index] * digitPlace);
			digitPlace *= 10;
		}

		for (int k = mat2.length - 1; k >= 0; k--) {
			sumOfMat2 += (mat2[k] * digitPlace2);
			digitPlace2 *= 10;
		}
		resultOfSum = sumOfMat + sumOfMat2;
		int staticResultOfSum = resultOfSum;
		while (resultOfSum > 10) {
			resultOfSum /= 10;
			counter++;
		}

		int[] mat3 = new int[counter + 1];
		for (int i = mat3.length - 1; i >= 0; i--) {
			mat3[i] = staticResultOfSum % 10;
			staticResultOfSum = staticResultOfSum / 10;
		}

		return mat3;
	}
}
