package afeka_Project3;

/*
 *Name:Shay Gabison ID:207726563 HomeWorkNumber:3
 *This class containing objects named Guest.
 *The objects properties in this class are: 
 *name= Guest name.
 *passportNumber=Guest passport number.
 */
public class Guest {
	private String name;
	private int passportNumber;

	public Guest(String name, int passportNumber) {
		this.name = name;
		this.passportNumber = passportNumber;
	}

	public String getname() {
		return name;
	}

	public int getpassportNumber() {
		return passportNumber;
	}

	public int setPassportNumber() {
		if (passportNumber > 0)
			return passportNumber;
		else {
			System.out.println("wrong input it reset auto to 0 please set passportnum again");
			return this.passportNumber = 0;
		}
	}

	public void setName() {
		this.name = name;
	}

	public String toString() {
		return "Guest name: " + name + " " + "Passport number: " + passportNumber;
	}
}
