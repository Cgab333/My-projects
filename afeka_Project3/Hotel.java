package afeka_Project3;

/*
 *Name:Shay Gabison ID:207726563 HomeWorkNumber:3
 *This class containing objects named Hotel.
 *The objects properties in this class are: 
 *numOfUsedRooms= The number of used rooms.
 *allRooms=Matrix type Room contain Room properties in each floor .
 *numberOfFloors, numberOfRooms= represent the hotel size.
 */
public class Hotel {
	private int numOfUsedRooms;
	private Room[][] allRooms;
	private int numberOfFloors, numberOfRooms;

	public Hotel(int numberOfFloors, int numberOfRooms) {
		this.numberOfFloors = numberOfFloors;
		this.numberOfRooms = numberOfRooms;
		allRooms = new Room[numberOfFloors][numberOfRooms];
		for (int floor = 0; floor < numberOfFloors; floor++) {
			for (int room = 0; room < numberOfRooms; room++) {
				allRooms[floor][room] = new Room((int) (Math.random() * 4) + 1);

			}

		}

	}

	public Hotel(Room[][] allRooms, int numOfUsedRooms) {
		this.allRooms = allRooms;
		this.numOfUsedRooms = numOfUsedRooms;
	}

	public Room[][] getallRooms() {
		return allRooms;
	}

	public int getnumOfUsedRooms() {
		return numOfUsedRooms;
	}

	public void Show() {
		System.out.println("Hotel details:\n ");
		System.out.println("Number of used rooms:  " + numOfUsedRooms);
		for (int floor = 0; floor < allRooms.length; floor++) {
			System.out.println();
			for (int room = 0; room < allRooms[0].length; room++) {
				System.out.println();
				if (allRooms[floor][room].isTaken()) {
					System.out.println("room " + (((floor + 1) * 100) + 1 + room) + " :");
					allRooms[floor][room].Show1();

				} else {
					System.out.println("room " + (((floor + 1) * 100) + 1 + room) + " is empty");
					System.out.println("number of beds:  " + allRooms[floor][room].getnumOfBeds());
				}
			}
		}
	}

	public int guestPlacement(Guest[] guestlist) {
		for (int floor = 0; floor < numberOfFloors; floor++) {
			for (int room = 0; room < numberOfRooms; room++) {
				if (guestlist.length <= 4 && guestlist.length < allRooms[floor][room].getnumOfBeds()) {
					allRooms[floor][room].setTaken(true);
					allRooms[floor][room].setAllGuests(guestlist);
					numOfUsedRooms++;
					return (((floor + 1) * 100) + 1 + room);

				}
			}
		}
		return -1;// method for guest placement in room.
	}

	public int isTheGuestInHotel(int passportNumber) {
		for (int i = 0; i < allRooms.length; i++) {
			for (int j = 0; j < allRooms[0].length; j++) {
				if (allRooms[i][j] != null && allRooms[i][j].isTheGuestInRoom(passportNumber))
					return (((i + 1) * 100) + 1 + j);
			}
		}
		return -1;
	}// method checking if the guest in the hotel.

	public int theMostEmptyFloor() {
		int roomAmount = 0;
		int oldRoomAmount = 0;
		int floorNumber = 0;
		for (int floor = 0; floor < allRooms.length; floor++) {
			for (int room = 0; room < allRooms[0].length; room++) {
				if (!allRooms[floor][room].isTaken()) {
					roomAmount++;
				}

			}
			if (oldRoomAmount < roomAmount) {
				floorNumber = floor + 1;
				oldRoomAmount = roomAmount;
			}
			roomAmount = 0;
		}
		return floorNumber;
	}// method checking what is the most empty floor in the hotel
}
