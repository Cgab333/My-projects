package afeka_Project3;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Name:Shay Gabison ID:207726563 HomeWorkNumber:3
 *
 * Menu of 4 option representing by switch. every case have a Detailed
 * documentation. Enjoy.
 *
 */
public class hotel_main {

	public static void main(String[] args) {
		int temp;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to hotel California!");
		System.out.println("Please enter the floors amount (1-10):");
		int numberOfFloors = input.nextInt();
		System.out.println("Thank you!");
		System.out.println("Please enter the Rooms per floor amount (1-100):");
		int numberOfRooms = input.nextInt();
		Hotel california = new Hotel(numberOfFloors, numberOfRooms);
		int menuChoice;
		do {
			System.out.println("Please select an option:\r\n"
					+ "1 - Absorption of guest data and place them  in the hotel room.\r\n"
					+ "2 - Receiving a guest's passport number and showing in which room it is stored.\r\n"
					+ "3 - View hotel details\r\n"
					+ "4 - Show which floor has the largest number of available rooms\r\n" + "5 - Exit\r\n" + "\r\n"
					+ " ");
			System.out.println("Enter one number please : ");
			menuChoice = input.nextInt();
			switch (menuChoice) {
			case (1):

				System.out.println("Please enter the  amount of guest you would like to absorption (1-4)");
				int amount = input.nextInt();
				while (amount > 4) {
					System.out.println(
							"There is no room in the hotel for more than for guest.\n Please enter the  amount of guest you would like to absorption (1-4) ");
					amount = input.nextInt();

				}
				Guest[] allGuests = new Guest[amount];
				for (int i = 0; i < amount; i++) {
					System.out.println("Please enter the guest name:");
					String name = input.next();
					System.out.println("Please enter the  guest passport number (POSITIVE)");
					int passportNumber = input.nextInt();
					while (passportNumber < 0) {
						System.out.println(
								"There Passport number must be positive.\n Please enter the  guest passport number (POSITIVE) ");
						passportNumber = input.nextInt();

					}
					Guest guest = new Guest(name, passportNumber);

					allGuests[i] = guest;
				}

				temp = california.guestPlacement(allGuests);
				if (temp == -1) {
					System.out.println("Not enught space");
				} else
					System.out.println("The guests entered room : " + temp);
				break;

			case (2):
				System.out.println("Please enter the  guest passport number (POSITIVE)");
				int passportNumber = input.nextInt();
				if (california.isTheGuestInHotel(passportNumber) == -1) {
					System.out.println("not a guest");
				} else {
					System.out.println(california.isTheGuestInHotel(passportNumber));
				}
				break;
			case (3):
				california.Show();

				break;
			case (4):
				System.out.println(" The most empty floor is " + california.theMostEmptyFloor());
				break;
			case (5):
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
		} while (menuChoice != 5);
	}

}
