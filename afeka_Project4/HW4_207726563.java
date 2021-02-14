package afeka_Project4;

import java.util.Scanner;

public class HW4_207726563 {

	/*
	 * Name:Shay Gabison ID:207726563 HomeWorkNumber:4
	 *
	 * Menu of 9 option representing by switch. 
	 * every function have a Detailed documentation. 
	 * Enjoy.
	 *
	 */
	public static void main(String[] args) {
		int menuChoice;
		int number;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please select an option:\r\n" + "1 - Amount of even numbers  (10.2)\r\n"
					+ "2 - Check if all numbers are even (10.3)\r\n"
					+ "3 - Check the amount of even numbers on array (10.4)\r\n"
					+ "4 - Check if all values in array are even (10.5)\r\n"
					+ "5 - Check if the number is 'replaced number'(10.8)\r\n"
					+ "6 - Check if at least pair of number are 'replaced digits' (10.9)\r\n"
					+ "7 - Upgraded 'Fibonacci Sequence'(10.20)\r\n" + "8 – Ruler Graduations (instruments) (10.22)\r\n"
					+ "9 - Exit\r\n" + "\r\n" + " ");
			System.out.println("enter one number : ");
			menuChoice = input.nextInt();
			switch (menuChoice) {// All the documentation in this switch cases is near the function under class
									// main.
			case (1):
				System.out.println("Please enter a number: ");
				System.out.println(evenNumbersAmount(input.nextInt()));
				break;
			case (2):
				System.out.println("Please enter a number: ");
				System.out.println(allDigitsAreEven(input.nextInt()));
				break;
			case (3):
				System.out.println("Please enter array length:");
				int[] arrayCase3 = new int[input.nextInt()];
				for (int i = 0; i < arrayCase3.length; i++) 
				{
					System.out.printf("Please enter value for index #%d:",i+1);
					arrayCase3[i] = input.nextInt();
				}
				System.out.println(evenNumbersAmountArry(arrayCase3));
				break;
			case (4):
				System.out.println("Please enter array length:");
				int[] arrayCase4 = new int[input.nextInt()];
				for (int i = 0; i < arrayCase4.length; i++) 
				{
					System.out.printf("Please enter value for index #%d:",i+1);
					arrayCase4[i] = input.nextInt();
				}
				System.out.println(allTheNumbersAreEvenCheck(arrayCase4));

				break;
			case (5):
				System.out.println("Please enter a number");
				System.out.println(replacedNumber(input.nextInt()));
				break;
			case (6):
				System.out.println("Please enter a number: ");
				System.out.println(replacedDigits(input.nextInt()));
				break;

			case 7:
				System.out.println("Please enter a number: ");
				System.out.println(findValueByIndex(input.nextInt()));
				break;
			case 8:
				System.out.println("Please enter a number: ");
				print22(input.nextInt());
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

	public static int evenNumbersAmount(int x) {
		return evenNumbersCount(x, 0);
	}
//evenNumbersCount is a recursive function that receives a number and returns the number of even numbers.
//The call to evenNumbersCount its through evenNumbersAmount.

	public static int evenNumbersCount(int x, int counter) {
		if (x == 0)
			return counter;
		if (x % 2 == 0) {
			return evenNumbersCount(x / 10, counter + 1);
		} else
			return evenNumbersCount(x / 10, counter);
	}
//allDigitsAreEven is a recursive function that receives a number and returns true if all its digits are even.
//Otherwise the function will return false.

	public static boolean allDigitsAreEven(int a) {
		if (a == 0) {
			return true;
		} else if ((a % 10) % 2 == 0)
			return allDigitsAreEven(a / 10);
		else
			return false;
	}
//evenNumbersCountArry is a recursive function that receives an array of numbers and its size and returns the number of even values.
//The call to evenNumbersCountArry its through evenNumbersAmountArry.
	public static int evenNumbersCountArry(int[] x, int index, int counter) {
		if (index == x.length)
			return counter;
		if (x[index] % 2 == 0)
			return evenNumbersCountArry(x, index + 1, counter + 1);
		else
			return evenNumbersCountArry(x, index + 1, counter);
	}

	public static int evenNumbersAmountArry(int[] x) {
		return evenNumbersCountArry(x, 0, 0);
	}
//evenNumberCount2 is a recursive function that takes an array of numbers and its size and returns true if all the values ​​in it are even.
//Otherwise the function will return false.
//The call to evenNumberCount2 its through allTheNumbersAreEvenCheck.
	public static boolean evenNumberCount2(int[] x, int index, int counter) {
		if (index == x.length)
			return true;
		if (x[index] % 2 == 0)
			return evenNumberCount2(x, index + 1, counter + 1);
		else
			return false;
	}

	public static boolean allTheNumbersAreEvenCheck(int[] x) {
		return evenNumberCount2(x, 0, 0);
	}
//replacedNumber is a boolean recursive function that gets an integer and returns true if the number is 'Replaced number'.
//Otherwise the function will return false.
	public static boolean replacedNumber(int number) {
		if ((number == 0))
			return true;
		else if (((number % 100 / 10) % 2 != 0 && (number % 10) % 2 == 0)
				|| ((number % 100 / 10) % 2 != 0 && (number % 10) % 2 == 0))
			return replacedNumber(number / 100);
		else
			return false;
	}
//replacedDigits is a boolean recursive function that gets an integer and returns true if it exists at least one pair of Replaced digits
//Otherwise the function will return false.
	public static boolean replacedDigits(int number) {
		if ((number == 0))
			return false;
		else if (((number % 100 / 10) % 2 != 0 && (number % 10) % 2 == 0)
				|| ((number % 100 / 10) % 2 != 0 && (number % 10) % 2 == 0))
			return true;
		else
			return replacedDigits(number / 100);
	}

//This function gets a sequence similar to 'Fibonacci Sequence' and return the current value the user ask for.
	public static int findValueByIndex(int n) {
		if (n < 4)
			return n;
		if (n % 2 == 0) {
			return findValueByIndex(n - 1) + findValueByIndex(n - 2) + findValueByIndex(n - 3);
		} else {
			return findValueByIndex(n - 1) - findValueByIndex(n - 3);
		}
	}
//print22 is a recursive function that takes an integer and draws ruler graduations (instruments) so that the number obtained is 
//the number of Ruler Graduations (instruments).
	public static void print22(int n) {
		if (n == 0)
			return;
		print22(n - 1);
		for (int i = 1; i <= n; i++)
			System.out.print("-");
		System.out.println();
		print22(n - 1);
	}

}