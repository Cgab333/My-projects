package afeka_Project3;

import java.util.Scanner;

/*
 * Name:Shay Gabison ID:207726563 HomeWorkNumber:3
 *
 * College main class .
 * In this main class the user can define college and absorb into lecturers.
 *
 */
public class college_main {

	public static void main(String[] args) {
		int numOfTimesPenFalls, maxNumOfLecturers, numberOfLecturerAtTheTime = 0;
		boolean addMoreLecturer;
		String name, favoriteIceCream;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the college name:");
		name = input.next();
		System.out.println("Please enter the maximum lecturers for the college: (number>2) ");
		maxNumOfLecturers = input.nextInt();
		input.nextLine();
		College firstCollege = new College(name, maxNumOfLecturers);
		addMoreLecturer = true;

		do {
			System.out.println("Add another lecturer? (true / false)");
			addMoreLecturer = input.nextBoolean();

			if (addMoreLecturer) {
				if (numberOfLecturerAtTheTime < maxNumOfLecturers) {
					System.out.println("Please enter the lecturer's name:");
					name = input.next();
					System.out.println("Please enter the lecturer's favorite ice cream :");
					favoriteIceCream = input.next();
					System.out.println("Please enter the number of times the pen falls:");
					numOfTimesPenFalls = input.nextInt();
					firstCollege.addLecturer(name, favoriteIceCream, numOfTimesPenFalls);
					numberOfLecturerAtTheTime++;
					System.out.println("Lecturer added successfully.");
				} else {
					if (numberOfLecturerAtTheTime == maxNumOfLecturers) {
						System.out.println("Could not add another lecturer - reached full capacity.");
						addMoreLecturer = false;
					} else
						break;
				}
			}

		} while (addMoreLecturer && numberOfLecturerAtTheTime <= maxNumOfLecturers);

		System.out.println(firstCollege.toString());
		System.out.println();
		System.out.println("The Lecturers information:");
		System.out.println();
		for (int i = 0; i < firstCollege.allLecturers.length; i++) {
			if (firstCollege.allLecturers[i] != null)
				System.out.println(firstCollege.allLecturers[i]);
			System.out.println();
		}
		input.close();

	}
}