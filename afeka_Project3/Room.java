package afeka_Project3;

/*
 *Name:Shay Gabison ID:207726563 HomeWorkNumber:3
 *This class containing objects named Room.
 *The objects properties in this class are: 
 *numOfBeds= The number of beds in the room.
 *allGuests=Array type Guest contain guest properties .
 */
public class Room {
	private int numOfBeds;
	private Guest[] allGuests;
	private boolean taken;

	public Room(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}

	public Room(Guest[] allGuests) {
		this.allGuests = allGuests;
	}

	public Guest[] getallGuests() {
		return allGuests;
	}

	public int getnumOfBeds() {
		return numOfBeds;
	}

	public void setAllGuests(Guest[] allGuests) {

		this.allGuests = allGuests;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public boolean isTaken() {
		return taken;
	}

	public boolean isTheGuestInRoom(int id) {
		if (allGuests == null) {
			return false;
		} else {
			for (int guest = 0; guest < allGuests.length; guest++) {

				if (id == allGuests[guest].getpassportNumber()) {
					return true;
				}
			}
		}
		return false;

	}// method checking if guest is in the room.

	public void Show1() {
		System.out.println("Number of beds: " + numOfBeds + " " + "Guest's list:\n");
		for (int i = 0; i < allGuests.length; i++) {
			if (allGuests[i] != null)
				System.out.println(allGuests[i].toString());
		}
	}
}
